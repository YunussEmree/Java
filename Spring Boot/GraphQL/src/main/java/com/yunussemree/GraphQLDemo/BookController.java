package com.yunussemree.GraphQLDemo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

        private final BookRepository repo;

        public BookController(BookRepository repo) {
            this.repo = repo;
        }

        @QueryMapping //QueryMapping is used to map GraphQL queries to methods
        public List<Book> books() {
            return repo.findAll();
        }

        @QueryMapping
        public Book bookById(@Argument Long id) {
            return repo.findById(id).orElse(null);
        }

        @MutationMapping //MutationMapping is used to map GraphQL mutations to methods
        public Book createBook(@Argument String title, @Argument String author) {
            return repo.save(new Book(title, author));
        }

        @MutationMapping
        public Book updateBook(@Argument Long id,
                               @Argument String title,
                               @Argument String author) {
            return repo.findById(id).map(b -> {
                if (title != null)  b.setTitle(title);
                if (author != null) b.setAuthor(author);
                return repo.save(b);
            }).orElse(null);
        }

        @MutationMapping
        public Boolean deleteBook(@Argument Long id) {
            if (!repo.existsById(id)) return false;
            repo.deleteById(id);
            return true;
        }



}

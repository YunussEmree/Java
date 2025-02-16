package com.YunussEmree.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    //@Qualifier("worldFileReader") // Qualifier annotation is used to specify which bean should be injected
    private Reader reader;

    @Autowired
    @Qualifier("worldFileReader") // Qualifier annotation is used to specify which bean should be injected
    private Reader reader2;


    @GetMapping("/read")
    public String read() {
         return reader.readFile() + " " + reader2.readFile();
    }

}

package com.yunussemree.redisexample.country;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
}

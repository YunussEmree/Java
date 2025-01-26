package com.YunussEmree.DependecyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DependecyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependecyInjectionApplication.class, args);
	}

	@Bean
	public SecondClass getSecondClass() {
		return new SecondClass();
	}
}

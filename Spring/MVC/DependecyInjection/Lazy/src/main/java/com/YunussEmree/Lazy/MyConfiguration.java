package com.YunussEmree.Lazy;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy // This annotation is used to make the beans and class lazy
// Lazy means that the beans will be created when they are needed
public class MyConfiguration {

    public MyConfiguration() {
        System.out.println("MyConfiguration bean initialized");
    }

    @Bean("example1")
    public Example1 getExample1() {
        return new Example1();
    }

    @Bean("example2")
    public Example2 getExample2() {
        return new Example2();
    }

}

package com.YunussEmree.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/requestparam")
public class Requestparam {


    @GetMapping(path = "/hi")
    public String sayHello3(@RequestParam String name){ //http://localhost:8080/demo/hi?name=Yunus
        return "Hi " + name + "!";
    }

}

package com.YunussEmree.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/required")
public class required {

    @GetMapping({"/hello","/hello/{name}"})
    public String sayHello(@PathVariable(name = "name", required = false) String name){
        return "Hello " + name + "!";
    }

    @GetMapping({"/hello2","/hello2/{name}"})
    public String sayHello2(@RequestParam(name = "name", required = false, defaultValue = "human") String name){
        return "Hello " + name + "!";
    }

}

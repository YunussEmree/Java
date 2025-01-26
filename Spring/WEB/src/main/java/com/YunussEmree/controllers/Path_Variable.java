package com.YunussEmree.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/path")
public class Path_Variable {

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/hello/{n}", method = RequestMethod.GET) //same as upper one
    public String sayHello2(@PathVariable("n") String name){
        return "Hello " + name + "!";
    }
}

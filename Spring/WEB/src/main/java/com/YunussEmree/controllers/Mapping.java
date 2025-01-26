package com.YunussEmree.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping")
public class Mapping {
    // GET :: for view data in browser
    // POST :: for saving data to server
    // PUT :: for updating data
    // DELETE :: for updating part of data
    // DELETE :: for deleting data


    //http://localhost:8080/demo

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/hello/{n}", method = RequestMethod.GET) //same as upper one
    public String sayHello2(@PathVariable("n") String name){
        return "Hello " + name + "!";
    }

    @GetMapping(path = "/get") // == @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String getData(){
        return "Data fetched! ";
    }

    @PostMapping(path = "/save")
    public String saveData(){
        return "Data saved! ";
    }

    @DeleteMapping(path = "/delete")
    public String deleteData(){
        return "Data deleted! ";
    }

    @PutMapping(path = "/update")
    public String updateData(){
        return "Data updated! ";
    }

    @PatchMapping(path = "/patch")
    public String patchData(){
        return "Data patched! ";
    }

}

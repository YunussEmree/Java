package com.YunussEmree.controllers.Requestheader;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requestheader")
public class Requestheader {

        @RequestMapping("/header")
        public String getHeader(@RequestHeader("My-Header") String name){
            return "Header is: " + name;
        }
}

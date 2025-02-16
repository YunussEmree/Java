package com.YunussEmree.controllers.Requestbody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reqbody")
public class Requestbody {

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        System.out.println("User  : " + user.getName() + " saved.");
        user.setPassword("********");
        return user;
    }

    @PostMapping("/users-all")
    public List<User> saveAllUsers(@RequestBody List<User> users){
        users.forEach(u -> System.out.println("User  : " + u.getName() + " saved."));
        users.forEach(u -> u.setPassword("********"));
        return users;
    }

    /*
            [
    {
        "name": "Yunus Emre",
            "surname": "Şenyiğit",
            "username": "user",
            "password": "user1234"
    },

    {
        "name": "Bekir",
            "surname": "Şenyiğit",
            "username": "user2",
            "password": "user12345"
    }
]
    */


}

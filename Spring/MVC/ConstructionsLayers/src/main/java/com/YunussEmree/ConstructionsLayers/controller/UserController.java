package com.YunussEmree.ConstructionsLayers.controller;

import com.YunussEmree.ConstructionsLayers.dto.User;
import com.YunussEmree.ConstructionsLayers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public User getUserbyId(@PathVariable("/userId") Long userId) {
        return userService.getUserbyId(userId);
    }
}

package com.YunussEmree.Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class SecondController {

    @Autowired
    private MyComponent myComponent;
}

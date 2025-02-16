package com.YunussEmree.Lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private Example1 example1;
    private Example2 example2;

    private MyComponent myComponent;

    public MyController(@Lazy MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    @GetMapping("/example1")
    public String getMyComponentName() {
        return myComponent.getName();
    }
}

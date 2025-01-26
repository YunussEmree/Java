package com.YunussEmree.Lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MyComponent {

    public MyComponent() {
        System.out.println("MyComponent bean initialized");
    }

    public String getName() {
        return "MyComponent";
    }


}

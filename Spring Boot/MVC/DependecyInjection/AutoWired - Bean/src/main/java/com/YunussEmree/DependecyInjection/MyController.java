package com.YunussEmree.DependecyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired // Dependency Injection with @Autowired annotation. firstClass will be created when program starts.
    private FirstClass firstClass;
    @Autowired
    private SecondClass secondClass;

    @GetMapping("/firstclass")
    public String getNameOfFirstClass() {
        return firstClass.getName();
    }

    @GetMapping("/secondclass")
    public String getNameOfSecondClass() {
        return secondClass.getName();
    }


}

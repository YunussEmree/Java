package com.YunussEmree.InjectionWays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    //@Autowired //Field Injection
    //private FirstClass firstClass; //Field Injection is not recommended

    private SecondClass secondClass;
    private FirstClass firstClass;
    private ThirdClass thirdClass;


    @Autowired
    public MyController(ThirdClass thirdClass, @Qualifier("firstClass") FirstClass firstClass) {
        this.thirdClass = thirdClass; //Constructor Injection
        this.firstClass = firstClass; //Constructor Injection
    }

    @RequestMapping("/names")
    public String getNameOfClasses(){
        return this.firstClass.getName() + " " + this.secondClass.getName() + " " + this.thirdClass.getName();
    }


    @Autowired //Setter Injection
    public void setSecondClass(SecondClass secondClass){
        this.secondClass = secondClass;
    }

}

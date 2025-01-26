package com.YunussEmree.IoC_Container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/application_context")
    public void examples(){ // This method will print all the beans in the IoC container
//        String[] beandefinitionnames = applicationContext.getBeanDefinitionNames();
//
//        for (String beandefinitionname : beandefinitionnames) {
//            System.out.println(beandefinitionname);
//        }



//        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
//        System.out.println("Bean Definition Count: " + beanDefinitionCount);

        MyComponent myComponent = (MyComponent) applicationContext.getBean("myComponent");
        MyComponent myComponent2 = applicationContext.getBean(MyComponent.class);
        System.out.println(myComponent.getname());
        System.out.println(myComponent2.getname());

        Class<?> myComponent1 = applicationContext.getType("myComponent");
        System.out.println(myComponent1.getSimpleName()); // returns class name

        System.out.println(applicationContext.containsBean("myComponent")); // returns true



    }




}

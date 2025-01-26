package com.YunussEmree.ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import otherpackage.MyComponent;

@SpringBootApplication
//@ComponentScan(basePackages = "otherpackage") //ComponentScan annotation is used to specify the packages that will be scanned for components.
											//default is the package of the class with this annotation
@ComponentScan(basePackages = {"otherpackage", "com.YunussEmree.ComponentScan"}) //multiple packages can be specified
@ComponentScan(basePackageClasses = MyComponent.class) //basePackageClasses attribute can be used to specify the class in the package to be scanned
public class ComponentScanApplication {

	@Autowired
	private MyComponent myComponent;



	public static void main(String[] args) {



		SpringApplication.run(ComponentScanApplication.class, args);
	}

}

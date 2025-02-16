package com.YunussEmree.IoC_Container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IoCContainerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(IoCContainerApplication.class, args);

		System.out.println(applicationContext.getClass());
	}

}

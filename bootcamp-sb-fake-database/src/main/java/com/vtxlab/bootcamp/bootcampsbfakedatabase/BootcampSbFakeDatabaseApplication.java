package com.vtxlab.bootcamp.bootcampsbfakedatabase;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@SpringBootApplication consist of @SpringBootConfiguration, @EnableAutoConfiguration & @ComponentScan

public class BootcampSbFakeDatabaseApplication {

	private static ConfigurableApplicationContext cac;  //carry the address of Spring Context

	public static ConfigurableApplicationContext getSprinContext(){
		return cac;
	}

	public static void main(String[] args) {
		//SpringApplication.run(BootcampSbFakeDatabaseApplication.class, args);
		
		//Spring Context
		cac = SpringApplication.run(BootcampSbFakeDatabaseApplication.class, args);
		String[] beans = cac.getBeanDefinitionNames();
		for(String bean : beans)
			System.out.println("bean = "+ bean);
	}

}

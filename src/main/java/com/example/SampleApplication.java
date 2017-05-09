package com.example;

import com.example.initial.SpringConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		initialExample(args);
	}


	private static void initialExample(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		context.getBean(SpringConfiguration.class).run(args);
		context.close();
	}
}

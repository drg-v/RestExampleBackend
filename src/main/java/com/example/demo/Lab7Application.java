package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.dao.InhabitantDao;
import com.example.demo.model.Inhabitant;


@SpringBootApplication
public class Lab7Application {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lab7Application.class, args);
		
	}
	
}

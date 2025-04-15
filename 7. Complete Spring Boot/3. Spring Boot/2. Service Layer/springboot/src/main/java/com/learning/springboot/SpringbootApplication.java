package com.learning.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.springboot.service.ProductServiceImpl;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{

	//	Soft Coupling the Service Layer Class here.
	@Autowired
	private ProductServiceImpl productServiceImpl ;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productServiceImpl.showProduct();
	}

}

package com.learning.sampleProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.sampleProject.service.ProductService;

@SpringBootApplication
public class SampleProjectApplication implements CommandLineRunner{
	
	//	Soft Coupling the Service Layer Class here.
	@Autowired
	private ProductService productServiceImpl ;
	

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productServiceImpl.showProductDetail();
	}

}

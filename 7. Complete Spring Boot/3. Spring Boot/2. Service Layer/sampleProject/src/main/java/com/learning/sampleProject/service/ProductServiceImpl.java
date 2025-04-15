package com.learning.sampleProject.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	//	It is an Service Implementation class of ProductService Interface hence it is named as ProductServiceImpl
	
	@Override
	public void showProductDetail() {
		System.out.println("Product Service Service is working fine.");
	}
	
}

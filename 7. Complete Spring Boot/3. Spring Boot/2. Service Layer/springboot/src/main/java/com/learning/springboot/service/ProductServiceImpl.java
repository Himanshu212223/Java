package com.learning.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	//	This is an implementation of ProductService Interface hence it is named as ProductServiceImpl
	
	@Override
	public void showProduct() {
		System.out.println("Show Product is working fine.");
	}

}

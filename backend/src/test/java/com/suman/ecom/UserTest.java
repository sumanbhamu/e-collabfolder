package com.suman.ecom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		System.out.println("hello");
		// TODO Auto-generated method stub

	}

}

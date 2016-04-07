package com.flea.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/flea/config/applicationContext.xml");
		
		//Test2 te = applicationContext.getBean(Test2.class);
		Test2 te = new Test2();
		te.test1();
	}
}

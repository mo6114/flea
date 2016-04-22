package com.flea.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flea.serviceImpl.FGoodsServiceImpl;
import com.flea.util.StringUtil;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/flea/config/applicationContext.xml");
		
		FGoodsServiceImpl fs = applicationContext.getBean(FGoodsServiceImpl.class);
		//Test2 te = new Test2();
		//fs.queryByConditions(1, 0, 1);
	}
	
	@Test
	public void testSting() {
		System.out.println(StringUtil.newFileName("aaaa.sql"));
	}
}

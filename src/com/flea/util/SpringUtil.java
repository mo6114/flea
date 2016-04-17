package com.flea.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	// 单例模式，并预防高并发
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"com/flea/config/applicationContext.xml");

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}

package com.flea.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flea.dao.FUserDao;
import com.flea.daoImpl.FUserDaoImpl;
import com.flea.service.FUserService;
import com.flea.serviceImpl.FUserServiceImpl;
import com.flea.util.SpringUtil;

public class FUserDaoImplTest {

	@Test
	public void test1() {
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/flea/config/applicationContext.xml");
		
		ApplicationContext applicationContext = SpringUtil.getApplicationContext();
		
		//FUserDao fUserDao = new FUserDaoImpl();
		//FUserDao fUserDao = (FUserDao) applicationContext.getBean("fUserDaoImpl");
		FUserDao fUserDao = applicationContext.getBean(FUserDaoImpl.class);
		
		System.out.println(fUserDao.queryFUserByEmail("aaa@qq.com"));
		
	}
	
	@Test
	public void test2() {
		ApplicationContext applicationContext = SpringUtil.getApplicationContext();
		
		FUserServiceImpl fUserService = applicationContext.getBean(FUserServiceImpl.class);
		
		//System.out.println(fUserService.test());
	}
}

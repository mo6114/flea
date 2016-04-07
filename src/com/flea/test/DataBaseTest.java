package com.flea.test;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.flea.entity.FUser;

@Component
public class DataBaseTest {

	@Resource(name = "sessionFactory1")
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Test
	public void testHibernate() {
		if(sessionFactory == null)
			System.out.println("null1");
		else
			System.out.println("mm");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		
		session.get("aaa@qq.com", FUser.class);
		System.out.println(session.get("aaa@qq.com", FUser.class));
		
		session.close();
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/flea/config/applicationContext.xml");
		SessionFactory sessionFactory1 = (SessionFactory) applicationContext.getBean("sessionFactory");
		if(sessionFactory1 == null)
			System.out.println("ni mei");
		else
			System.out.println("xixi");
		
		
		/*SessionFactory sessionFactory = new DataBaseTest().getSessionFactory();
		if(sessionFactory == null)
			System.out.println("null1222");*/
		
		Session session = sessionFactory1.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from FUser");
		List<FUser> list = query.list();
		for(FUser fUser : list)
			System.out.println(fUser);
		
		session.close();
	}
}

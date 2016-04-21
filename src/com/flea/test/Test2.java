package com.flea.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.flea.entity.FUser;

public class Test2 {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void test1() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from FUser");
		List<FUser> list = query.list();
		for(FUser fUser : list)
			System.out.println(fUser);
		
		session.close();
	}
	
	@Test
	public void test() {
		System.out.println("ss123.com".indexOf('@'));
	}
}

package com.flea.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flea.dao.FUserDao;
import com.flea.entity.FUser;

public class FUserDaoImpl implements FUserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public FUser queryFUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		/*Query query = session.createQuery("from FUser where email = ?");
		query.setString(0, email);
		FUser fUser = (FUser) query.uniqueResult();*/
		FUser fUser = null;
		if("aa@aa.com".equals(email))
			fUser = new FUser();
		else
			System.out.println("ddd");
		System.out.println(email);

		return fUser;
	}

	@Override
	public FUser queryFUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		/*Query query = session.createQuery("from FUser where userName = ?");
		query.setString(0, userName);
		FUser fUser = (FUser) query.uniqueResult();*/

		FUser fUser = null;
		if("aa".equals(userName))
			fUser = new FUser();
		
		System.out.println(fUser);
		System.out.println(userName);
		
		return fUser;
	}

	@Override
	public void updateFUser(FUser fUser) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(fUser);
	}

	@Override
	public void insertFUser(FUser fUser) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//session.save(fUser);
	}

}

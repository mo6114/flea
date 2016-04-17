package com.flea.serviceImpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flea.dao.FUserDao;
import com.flea.entity.FUser;
import com.flea.service.FUserService;

public class FUserServiceImpl implements FUserService {

private SessionFactory sessionFactory;
	
	private FUserDao fUserDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public FUserDao getfUserDao() {
		return fUserDao;
	}

	public void setfUserDao(FUserDao fUserDao) {
		this.fUserDao = fUserDao;
	}
	
	public FUser test() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		FUser fUser =  fUserDao.queryFUserByEmail("aaa@qq.com");
		
		transaction.commit();
		
		return fUser;
	}
}

package com.flea.serviceImpl;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flea.dao.FUserDao;
import com.flea.entity.FUser;
import com.flea.service.FUserService;
import com.flea.util.MD5Utils;

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

	@Override
	public void register(FUser fUser) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println(fUser);
		
		try {
			fUser.setRegisterTime(new Date());
			fUser.setStatus(0);
			fUser.setAccount(0);
			fUser.setPassword(MD5Utils.generateMD5Code(fUser.getPassword()));
			System.out.println(fUser);
			fUserDao.insertFUser(fUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		
		transaction.commit();
	}

	@Override
	public FUser queryFUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		FUser fUser = null;
		
		try {
			fUser = fUserDao.queryFUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		
		transaction.commit();
		
		return fUser;
	}

	@Override
	public FUser queryFUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		FUser fUser = null;
		
		try {
			fUser = fUserDao.queryFUserByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		
		transaction.commit();
		
		return fUser;
	}
}

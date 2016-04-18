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

	/*
	 * service层测试方法 public FUser test() { Session session =
	 * sessionFactory.getCurrentSession(); Transaction transaction =
	 * session.beginTransaction();
	 * 
	 * FUser fUser = fUserDao.queryFUserByEmail("aaa@qq.com");
	 * 
	 * transaction.commit();
	 * 
	 * return fUser; }
	 */

	// 用户注册
	@Override
	public void register(FUser fUser) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// System.out.println(fUser);

		try {
			// 初始化用户信息中的注册时间、用户状态、账户信息
			fUser.setRegisterTime(new Date());
			fUser.setStatus(0);
			fUser.setAccount(0);
			// 对用户密码进行MD5加密并重新设置用户密码为加密后密码
			fUser.setPassword(MD5Utils.generateMD5Code(fUser.getPassword()));
			// System.out.println(fUser);
			// 插入信息
			fUserDao.insertFUser(fUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}

		transaction.commit();
	}

	@Override
	public FUser queryFUserByEmail(String email) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		FUser fUser = null;

		try {
			// 通过邮箱查询
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
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		FUser fUser = null;

		try {
			// 通过用户名查询
			fUser = fUserDao.queryFUserByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}

		transaction.commit();

		return fUser;
	}
}

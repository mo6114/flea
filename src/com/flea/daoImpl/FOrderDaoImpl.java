package com.flea.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flea.dao.FOrderDao;
import com.flea.entity.FOrder;

public class FOrderDaoImpl implements FOrderDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertFOrder(FOrder fOrder) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println(fOrder);
		// 插入
		session.save(fOrder);
	}
}

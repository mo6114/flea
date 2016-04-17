package com.flea.daoImpl;

import org.hibernate.SessionFactory;

import com.flea.dao.FOrderDao;

public class FOrderDaoImpl implements FOrderDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

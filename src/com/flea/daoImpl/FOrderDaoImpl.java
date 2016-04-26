package com.flea.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flea.dao.FOrderDao;
import com.flea.entity.FGoods;
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

	@Override
	public List<FOrder> queryByHql(String hql, int pageNum, int pageSize, String email) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		query.setString(0, email);

		return query.list();
	}

	@Override
	public FOrder queryById(String id) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		return (FOrder) session.get(FOrder.class, id);
	}
}

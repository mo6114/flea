package com.flea.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flea.dao.FGoodsDao;
import com.flea.entity.FGoods;

public class FGoodsDaoImpl implements FGoodsDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 上架新商品
	@Override
	public void insertFGoods(FGoods fGoods) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//System.out.println(fGoods);
		// 插入
		session.save(fGoods);
	}
}

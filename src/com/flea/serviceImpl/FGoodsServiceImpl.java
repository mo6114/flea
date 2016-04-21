package com.flea.serviceImpl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flea.dao.FGoodsDao;
import com.flea.entity.FGoods;
import com.flea.service.FGoodsService;
import com.flea.util.MD5Utils;

public class FGoodsServiceImpl implements FGoodsService {

	private SessionFactory sessionFactory;
	private FGoodsDao fGoodsDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public FGoodsDao getfGoodsDao() {
		return fGoodsDao;
	}

	public void setfGoodsDao(FGoodsDao fGoodsDao) {
		this.fGoodsDao = fGoodsDao;
	}

	@Override
	public void onShelves(FGoods fGoods) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			//设置fGoods基本属性
			fGoods.setTimeOnShelves(new Date());
			fGoods.setStatus(1);
			fGoods.setTimes(0);
			fGoodsDao.insertFGoods(fGoods);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}

		transaction.commit();
	}
}

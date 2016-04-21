package com.flea.serviceImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flea.dao.FGoodsDao;
import com.flea.entity.FGoods;
import com.flea.service.FGoodsService;
import com.flea.util.CategoryUtil;
import com.flea.util.MD5Utils;
import com.flea.util.StringUtil;

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
			// 设置fGoods基本属性
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

	//通过类别码与排序码查询商品
	@Override
	public List<FGoods> queryByConditions(int categoryNum, int orderByNum,int ruleNum) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			String hql = StringUtil.createHQL(categoryNum, orderByNum, ruleNum);
			fGoodsDao.queryByHQL(hql, CategoryUtil.getCategory(categoryNum));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
		return null;
	}
}

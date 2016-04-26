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

	// 上架新商品
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
			System.out.println(fGoods);
			fGoods.setOne_level(CategoryUtil.getCategory(Integer.parseInt(fGoods.getOne_level())));
			fGoods.setTwo_level(CategoryUtil.getCategory(Integer.parseInt(fGoods.getTwo_level())));
			System.out.println(fGoods);
			fGoodsDao.insertFGoods(fGoods);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}

		transaction.commit();
	}

	// 通过类别码与排序码查询商品
	@Override
	public List<FGoods> queryByConditions(int categoryNum, int orderByNum, int ruleNum, int pageNum, int pageSize) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<FGoods> fGoodsList = null;

		try {
			String hql = StringUtil.createHQL(categoryNum, orderByNum, ruleNum);
			fGoodsList = fGoodsDao.queryByHQL(hql, pageNum, pageSize, CategoryUtil.getCategory(categoryNum));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
		return fGoodsList;
	}

	@Override
	public FGoods queryById(String id, int times) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		FGoods fGoods = null;

		try {
			fGoods = fGoodsDao.queryById(id);
			if (times == 1)
				fGoods.setTimes(fGoods.getTimes() + times);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		return fGoods;
	}

	@Override
	public List<FGoods> queryByStatus(int status, int pageNum, int pageSize, String email) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<FGoods> fGoodsList = null;

		try {
			String hql = StringUtil.createHQLForFGoods(status);
			fGoodsList = fGoodsDao.queryByHql(hql, pageNum, pageSize, email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
		return fGoodsList;
	}

	// 商品下架
	@Override
	public void goodsSoldOut(String id) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			FGoods fGoods = fGoodsDao.queryById(id);
			fGoods.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
	}
}

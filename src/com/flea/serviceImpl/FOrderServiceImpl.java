package com.flea.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flea.dao.FGoodsDao;
import com.flea.dao.FOrderDao;
import com.flea.dao.FUserDao;
import com.flea.entity.FGoods;
import com.flea.entity.FOrder;
import com.flea.entity.FUser;
import com.flea.service.FOrderService;
import com.flea.util.CategoryUtil;

public class FOrderServiceImpl implements FOrderService {

	private SessionFactory sessionFactory;
	private FOrderDao fOrderDao;
	private FGoodsDao fGoodsDao;
	private FUserDao fUserDaoImpl;

	public FOrderDao getfOrderDao() {
		return fOrderDao;
	}

	public void setfOrderDao(FOrderDao fOrderDao) {
		this.fOrderDao = fOrderDao;
	}

	public FUserDao getfUserDaoImpl() {
		return fUserDaoImpl;
	}

	public void setfUserDaoImpl(FUserDao fUserDaoImpl) {
		this.fUserDaoImpl = fUserDaoImpl;
	}

	public FGoodsDao getfGoodsDao() {
		return fGoodsDao;
	}

	public void setfGoodsDao(FGoodsDao fGoodsDao) {
		this.fGoodsDao = fGoodsDao;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 购买单件商品
	@Override
	public String createFOrder(FOrder fOrder, String goodsId, String buyerEmail) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			FGoods fGoods = fGoodsDao.queryById(goodsId);

			if (fGoods != null) {
				fOrder.setbEmail(buyerEmail);
				fOrder.setsEmail(fGoods.getEmail());
				fOrder.setGoodsId(goodsId);
				fOrder.setStatus(1);
				fOrder.setOrderTime(new Date());

				FUser bFUser = fUserDaoImpl.queryFUserByEmail(buyerEmail);
				if (bFUser != null) {
					if (bFUser.getAccount() < fGoods.getPrice())
						return "FundsNotEnough";
					else
						bFUser.setAccount(bFUser.getAccount() - fGoods.getPrice());
				} else {
					throw new RuntimeException("error");
				}
			} else
				throw new RuntimeException("error");

			fOrderDao.insertFOrder(fOrder);

			fGoods.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		transaction.commit();
		return null;
	}

	//购买多件商品
	@Override
	public String createFOrder(FOrder fOrder, Set<FGoods> shoppingCart, String buyerEmail) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			fOrder.setbEmail(buyerEmail);
			fOrder.setStatus(1);
			fOrder.setOrderTime(new Date());

			FUser bFUser = fUserDaoImpl.queryFUserByEmail(buyerEmail);
			if (bFUser != null) {
				for (FGoods fGoods : shoppingCart) {
					FOrder order = fOrder;

					order.setsEmail(fGoods.getEmail());
					order.setGoodsId(fGoods.getId());

					if (bFUser.getAccount() < fGoods.getPrice())
						return "FundsNotEnough";
					else
						bFUser.setAccount(bFUser.getAccount() - fGoods.getPrice());
					fGoods.setStatus(0);
					fOrderDao.insertFOrder(order);
				}
			} else {
				throw new RuntimeException("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		transaction.commit();
		return null;
	}

}

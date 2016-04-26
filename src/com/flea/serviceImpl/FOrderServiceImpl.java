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
import com.flea.util.StringUtil;

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

	// 购买多件商品
	// @Override
	/*
	 * public String createFOrder(FOrder fOrder, Set<FGoods> shoppingCart,
	 * String buyerEmail) {
	 * 
	 * try { fOrder.setbEmail(buyerEmail); fOrder.setStatus(1);
	 * fOrder.setOrderTime(new Date());
	 * 
	 * FUser bFUser = fUserDaoImpl.queryFUserByEmail(buyerEmail); if (bFUser !=
	 * null) { for (FGoods fGoods : shoppingCart) { // 获取session并开启事务 Session
	 * session = sessionFactory.getCurrentSession(); Transaction transaction =
	 * session.beginTransaction();
	 * 
	 * FOrder order = fOrder;
	 * 
	 * order.setsEmail(fGoods.getEmail()); order.setGoodsId(fGoods.getId());
	 * 
	 * if (bFUser.getAccount() < fGoods.getPrice()) return "FundsNotEnough";
	 * else bFUser.setAccount(bFUser.getAccount() - fGoods.getPrice());
	 * fGoods.setStatus(0); System.out.println(fGoods);
	 * fOrderDao.insertFOrder(order); transaction.commit(); } } else { throw new
	 * RuntimeException("error"); } } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * return null; }
	 */

	// 购买多件商品
	@Override
	public String createFOrder(FOrder fOrder, Set<FGoods> shoppingCart, String buyerEmail) {
		try {
			for (FGoods fGoods : shoppingCart) {
				createFOrder(fOrder, fGoods.getId(), buyerEmail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 通过订单状态及邮箱查询订单
	@Override
	public List<FOrder> queryByStatusForSaler(int status, int pageNum, int pageSize, String email) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<FOrder> fOrderList = null;

		try {
			String hql = StringUtil.createHQLForFOrderSaler(status);
			fOrderList = fOrderDao.queryByHql(hql, pageNum, pageSize, email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();

		for (FOrder fOrder : fOrderList)
			System.out.println(fOrder);

		return fOrderList;
	}

	// 通过订单状态及邮箱查询订单
	@Override
	public List<FOrder> queryByStatusForBuyer(int status, int pageNum, int pageSize, String email) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<FOrder> fOrderList = null;

		try {
			String hql = StringUtil.createHQLForFOrderBuyer(status);

			fOrderList = fOrderDao.queryByHql(hql, pageNum, pageSize, email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
		return fOrderList;
	}

	@Override
	public void confirmOrder(String id) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			FOrder fOrder = fOrderDao.queryById(id);
			fOrder.setStatus(2);
			fOrder.setFinishTime(new Date());

			FUser saler = fUserDaoImpl.queryFUserByEmail(fOrder.getsEmail());
			FGoods goods = fGoodsDao.queryById(fOrder.getGoodsId());
			saler.setAccount(saler.getAccount() + goods.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
	}

	@Override
	public void cancelOrderForBuyer(String id) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			FOrder fOrder = fOrderDao.queryById(id);
			fOrder.setStatus(0);
			fOrder.setFinishTime(new Date());

			FUser buyer = fUserDaoImpl.queryFUserByEmail(fOrder.getbEmail());
			FGoods goods = fGoodsDao.queryById(fOrder.getGoodsId());
			buyer.setAccount(buyer.getAccount() + goods.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
	}

	@Override
	public void cancelOrderForSaler(String id) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			FOrder fOrder = fOrderDao.queryById(id);
			fOrder.setStatus(0);
			fOrder.setFinishTime(new Date());

			FUser buyer = fUserDaoImpl.queryFUserByEmail(fOrder.getbEmail());
			FGoods goods = fGoodsDao.queryById(fOrder.getGoodsId());
			buyer.setAccount(buyer.getAccount() + goods.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error");
		}
		transaction.commit();
	}

}

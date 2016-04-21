package com.flea.daoImpl;

import java.util.List;

import org.hibernate.Query;
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
		// System.out.println(fGoods);
		// 插入
		session.save(fGoods);
	}

	// 通过service层的HQL语句查询
	@Override
	public List<FGoods> queryByHQL(String hql, String... strings) {
		// 获取session并开启事务
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		hql = "from FGoods " + hql;
		System.out.println(hql);
		Query query = session.createQuery(hql);
		if (strings != null) {
			int i = 0;
			for (String string : strings) {
				query.setString(i, string);
				i++;
			}
		}
		return query.list();
	}
}

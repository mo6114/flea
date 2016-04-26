package com.flea.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.flea.entity.FGoods;

public interface FGoodsDao {

	public void insertFGoods(FGoods fGoods);

	public List<FGoods> queryByHQL(String hql, int pageNum, int pageSize, String... str);

	public FGoods queryById(String id);

	public List<FGoods> queryByHql(String hql, int pageNum, int pageSize , String email);
}

package com.flea.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;

public interface FOrderDao {

	public void insertFOrder(FOrder fOrder);

	public List<FOrder> queryByHql(String hql, int pageNum, int pageSize, String email);
	
	public FOrder queryById(String id);
}

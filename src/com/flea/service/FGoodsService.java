package com.flea.service;

import java.util.List;

import com.flea.entity.FGoods;

public interface FGoodsService {

	public void onShelves(FGoods fGoods);
	
	public void goodsSoldOut(String id);

	public List<FGoods> queryByConditions(int categoryNum, int orderByNum, int ruleNum, int pageNum, int pageSize);

	public List<FGoods> queryByStatus(int status, int pageNum, int pageSize , String email);

	public FGoods queryById(String id, int times);
	
	public List<FGoods> queryByCategory(int categoryNum);
}

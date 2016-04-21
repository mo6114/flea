package com.flea.service;

import java.util.List;

import com.flea.entity.FGoods;

public interface FGoodsService {

	public void onShelves(FGoods fGoods);

	public List<FGoods> queryByConditions(int categoryNum, int orderByNum, int ruleNum);
}

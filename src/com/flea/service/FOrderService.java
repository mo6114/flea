package com.flea.service;

import java.util.List;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;

public interface FOrderService {

	public String createFOrder(FOrder fOrder, String goodsId, String buyerEmail);

	public String createFOrder(FOrder fOrder, List<FGoods> shoppingCart, String buyerEmail);
}

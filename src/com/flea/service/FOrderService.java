package com.flea.service;

import java.util.List;
import java.util.Set;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;

public interface FOrderService {

	public String createFOrder(FOrder fOrder, String goodsId, String buyerEmail);

	public String createFOrder(FOrder fOrder, Set<FGoods> shoppingCart, String buyerEmail);
}

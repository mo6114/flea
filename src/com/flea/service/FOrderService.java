package com.flea.service;

import java.util.List;
import java.util.Set;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;

public interface FOrderService {

	public String createFOrder(FOrder fOrder, String goodsId, String buyerEmail);

	public String createFOrder(FOrder fOrder, Set<FGoods> shoppingCart, String buyerEmail);

	public List<FOrder> queryByStatusForSaler(int status, int pageNum, int pageSize, String email);

	public List<FOrder> queryByStatusForBuyer(int status, int pageNum, int pageSize, String email);

	public void confirmOrder(String id);

	public void cancelOrderForBuyer(String id);

	public void cancelOrderForSaler(String id);
}

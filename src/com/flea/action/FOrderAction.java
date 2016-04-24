package com.flea.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;
import com.flea.service.FGoodsService;
import com.flea.service.FOrderService;
import com.flea.util.StringUtil;

public class FOrderAction extends BaseAction {

	private String id;
	private int amount;
	private String space;
	private Date saleTime;
	private FOrderService fOrderService;
	private FGoodsService fGoodsService;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		if (amount == 0)
			return 1;
		else
			return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public FGoodsService getfGoodsService() {
		return fGoodsService;
	}

	public void setfGoodsService(FGoodsService fGoodsService) {
		this.fGoodsService = fGoodsService;
	}

	public FOrderService getfOrderService() {
		return fOrderService;
	}

	public void setfOrderService(FOrderService fOrderService) {
		this.fOrderService = fOrderService;
	}

	// 控制点击购买按钮后的跳转
	public String controlBuySkip() {
		try {
			this.setValue("#session.fGoodsId", id);
			FGoods fGoods = fGoodsService.queryById(id, 1);
			this.setValue("#session.fGoods", fGoods);
			if (this.findValue("#session.shoppingCart") == null) {
				List<FGoods> shoppingCart = new ArrayList<FGoods>();
				shoppingCart.add(fGoods);
				this.setValue("#session.shoppingCart", shoppingCart);
			} else {
				List<FGoods> shoppingCart = (List<FGoods>) this.findValue("#session.shoppingCart");
				shoppingCart.add(fGoods);
				this.setValue("#session.shoppingCart", shoppingCart);
			}
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// 购买单件商品
	public String buyOneGoods() {
		String string = null;
		try {
			FOrder fOrder = new FOrder();
			fOrder.setAmount(getAmount());
			fOrder.setSpace(space);
			fOrder.setSaleTime(saleTime);
			System.out.println(fOrder);

			String goodsId = (String) this.findValue("#session.fGoodsId");
			String buyerEmail = (String) this.findValue("#session.email");
			System.out.println("buyerEmail" + buyerEmail);
			string = fOrderService.createFOrder(fOrder, goodsId, buyerEmail);

			FGoods fGoods = (FGoods) this.findValue("#session.fGoods");
			this.removeSession("fGoodsId");
			this.removeSession("fGoods");
			List<FGoods> shoppingCart = (List<FGoods>) this.findValue("#session.shoppingCart");
			shoppingCart.remove(fGoods);
			this.setValue("#session.shoppingCart", shoppingCart);
		} catch (Exception e) {
			
		}
		if("FundsNotEnough".equals(string))
			return "FundsNotEnough";
		else
			return "success";
	}
	
	//购买多件商品
	public String buyGoods() {
		String string = null;
		try {
			
		} catch (Exception e) {
			
		}
		if("FundsNotEnough".equals(string))
			return "FundsNotEnough";
		else
			return "success";
	}
	
	//购买多件商品时的session操作
	public List<FGoods> shoppingCartOperate(List<String> fGoodsIdList) {
		List<FGoods> fGoodsList = new ArrayList<FGoods>();
		for(String fGoodsId : fGoodsIdList)
			fGoodsList.add(fGoodsService.queryById(fGoodsId, 0));
		
		List<FGoods> shoppingCart = (List<FGoods>) this.findValue("#session.shoppingCart");
		shoppingCart.removeAll(fGoodsList);
		
		if(shoppingCart.isEmpty())
			this.removeSession("shoppingCart");
		
		return fGoodsList;
	}
}

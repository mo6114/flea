package com.flea.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.flea.entity.FGoods;
import com.flea.entity.FOrder;
import com.flea.entity.FOrderForPage;
import com.flea.service.FGoodsService;
import com.flea.service.FOrderService;
import com.flea.util.StringUtil;

public class FOrderAction extends BaseAction {

	private String id;
	private int amount;
	private String space;
	private Date saleTime;
	private int status;
	private int pageNum;
	private int pageSize;
	private List<String> fGoodsIdList;
	private FOrderService fOrderService;
	private FGoodsService fGoodsService;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPageNum() {
		if (pageNum == 0)
			return 1;
		else
			return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getfGoodsIdList() {
		return fGoodsIdList;
	}

	public void setfGoodsIdList(List<String> fGoodsIdList) {
		this.fGoodsIdList = fGoodsIdList;
	}

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
				// List<FGoods> shoppingCart = new ArrayList<FGoods>();
				Set<FGoods> shoppingCart = new HashSet<FGoods>();
				shoppingCart.add(fGoods);
				this.setValue("#session.shoppingCart", shoppingCart);
			} else {
				// List<FGoods> shoppingCart = (List<FGoods>)
				// this.findValue("#session.shoppingCart");
				Set<FGoods> shoppingCart = (Set<FGoods>) this.findValue("#session.shoppingCart");
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
			// System.out.println(fOrder);

			String goodsId = (String) this.findValue("#session.fGoodsId");
			// System.out.println(goodsId);
			String buyerEmail = (String) this.findValue("#session.email");
			// System.out.println("buyerEmail" + buyerEmail);
			string = fOrderService.createFOrder(fOrder, goodsId, buyerEmail);

			FGoods fGoods = (FGoods) this.findValue("#session.fGoods");
			this.removeSession("fGoodsId");
			this.removeSession("fGoods");
			Set<FGoods> shoppingCart = (Set<FGoods>) this.findValue("#session.shoppingCart");
			shoppingCart.remove(fGoods);
			this.setValue("#session.shoppingCart", shoppingCart);
		} catch (Exception e) {

		}
		if ("FundsNotEnough".equals(string))
			return "FundsNotEnough";
		else
			return "success";
	}

	// 购买多件商品(通过购物车购买)
	public String buyGoods() {
		String string = null;
		try {
			FOrder fOrder = new FOrder();
			fOrder.setAmount(getAmount());
			fOrder.setSpace(space);
			fOrder.setSaleTime(saleTime);

			String buyerEmail = (String) this.findValue("#session.email");

			//System.out.println("space:" + getRequest().getParameter("space"));
			String[] tmp = getRequest().getParameterValues("fGoodsIdList");
			Set<FGoods> fGoodsList = shoppingCartOperate(tmp);
			string = fOrderService.createFOrder(fOrder, fGoodsList, buyerEmail);
		} catch (Exception e) {

		}
		if ("FundsNotEnough".equals(string))
			return "FundsNotEnough";
		else
			return "success";
	}

	// 添加购物车项
	public void insertShoppingCart() {
		FGoods fGoods = fGoodsService.queryById(id, 1);
		if (this.findValue("#session.shoppingCart") == null) {
			// List<FGoods> shoppingCart = new ArrayList<FGoods>();
			Set<FGoods> shoppingCart = new HashSet<FGoods>();
			shoppingCart.add(fGoods);
			this.setValue("#session.shoppingCart", shoppingCart);
		} else {
			// List<FGoods> shoppingCart = (List<FGoods>)
			// this.findValue("#session.shoppingCart");
			Set<FGoods> shoppingCart = (Set<FGoods>) this.findValue("#session.shoppingCart");
			shoppingCart.add(fGoods);
			// this.setValue("#session.shoppingCart", shoppingCart);
		}
	}

	// 购买多件商品时的session操作
	public Set<FGoods> shoppingCartOperate(String[] fGoodsIdList) {
		// List<FGoods> fGoodsList = new ArrayList<FGoods>();
		Set<FGoods> fGoodsList = new HashSet<FGoods>();
		for (String fGoodsId : fGoodsIdList) {
			fGoodsList.add(fGoodsService.queryById(fGoodsId, 0));
		}

		// List<FGoods> shoppingCart = (List<FGoods>)
		// this.findValue("#session.shoppingCart");
		Set<FGoods> shoppingCart = null;
		if ((Set<FGoods>) this.findValue("#session.shoppingCart") != null)
			shoppingCart = (Set<FGoods>) this.findValue("#session.shoppingCart");
		shoppingCart.removeAll(fGoodsList);

		if (shoppingCart == null || shoppingCart.isEmpty())
			this.removeSession("shoppingCart");

		return fGoodsList;
	}

	// 根据status生成HQL,0代表全部交易，1代表待交易商品，2代表已完成交易，3代表已取消交易
	public String queryByStatusForBuyer() {
		try {
			if (status == 0)
				status = (int) this.findValue("#session.fOrderForBuyerStatus");
			this.setValue("#session.fOrderForBuyerStatus", status);
			String email = (String) this.findValue("#session.email");

			List<FOrder> fOrderList = fOrderService.queryByStatusForBuyer(status, getPageNum(), pageSize, email);

			List<FOrderForPage> fOrderForPage = new ArrayList<FOrderForPage>();
			for (FOrder fOrder : fOrderList) {
				FGoods fGoods = fGoodsService.queryById(fOrder.getGoodsId(), 0);
				fOrderForPage.add(new FOrderForPage(fGoods.getName(), fGoods.getPrice(), fOrder.getbEmail(),
						fOrder.getsEmail(), fOrder.getSaleTime(), fOrder.getSpace()));
			}

			this.setValue("#session.fOrderList", fOrderForPage);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// 根据status生成HQL,0代表全部交易，1代表待交易商品，2代表已完成交易，3代表已取消交易
	public String queryByStatusForSaler() {
		try {
			if (status == 0)
				status = (int) this.findValue("#session.fOrderForSalerStatus");
			this.setValue("#session.fOrderForSalerStatus", status);
			String email = (String) this.findValue("#session.email");

			List<FOrder> fOrderList = fOrderService.queryByStatusForSaler(status, getPageNum(), pageSize, email);

			List<FOrderForPage> fOrderForPage = new ArrayList<FOrderForPage>();
			for (FOrder fOrder : fOrderList) {
				FGoods fGoods = fGoodsService.queryById(fOrder.getGoodsId(), 0);
				fOrderForPage.add(new FOrderForPage(fGoods.getName(), fGoods.getPrice(), fOrder.getbEmail(),
						fOrder.getsEmail(), fOrder.getSaleTime(), fOrder.getSpace()));
			}

			this.setValue("#session.fOrderList", fOrderForPage);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// 确认订单
	public String confirmOrder() {
		try {
			fOrderService.confirmOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// 买家取消订单
	public String cancelOrderForBuyer() {
		try {
			fOrderService.cancelOrderForBuyer(id);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// 卖家取消订单
	public String cancelOrderForSaler() {
		try {
			fOrderService.cancelOrderForSaler(id);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}
}

package com.flea.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.flea.entity.FGoods;
import com.flea.service.FGoodsService;
import com.flea.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FGoodsAction extends BaseAction {

	private String id;
	private int times;
	private String name;
	private String two_level;
	private String one_level;
	private String introduction;
	private float price;
	private int amount;
	private int status;
	// 上传上来的图片内容及名称
	private File picture;
	private String pictureFileName;
	private int categoryNum;
	private int orderByNum;
	private int ruleNum;
	private int pageNum;
	private int pageSize;
	private FGoodsService fGoodsService;
	private FGoods fGoods;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public int getOrderByNum() {
		return orderByNum;
	}

	public void setOrderByNum(int orderByNum) {
		this.orderByNum = orderByNum;
	}

	public int getRuleNum() {
		return ruleNum;
	}

	public void setRuleNum(int ruleNum) {
		this.ruleNum = ruleNum;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTwo_level() {
		return two_level;
	}

	public void setTwo_level(String two_level) {
		this.two_level = two_level;
	}

	public String getOne_level() {
		return one_level;
	}

	public void setOne_level(String one_level) {
		this.one_level = one_level;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public FGoodsService getfGoodsService() {
		return fGoodsService;
	}

	public void setfGoodsService(FGoodsService fGoodsService) {
		this.fGoodsService = fGoodsService;
	}

	public FGoods getfGoods() {
		return fGoods;
	}

	public void setfGoods(FGoods fGoods) {
		this.fGoods = fGoods;
	}

	// 上架新商品
	public String onShelves() {
		try {
			// 设置fGoods属性
			fGoods.setName(name);
			fGoods.setEmail((String) this.findValue("#session.email"));
			fGoods.setOne_level(one_level);
			fGoods.setTwo_level(two_level);
			fGoods.setIntroduction(introduction);
			fGoods.setPrice(price);
			fGoods.setAmount(amount);
			// 重新生成文件名，防止出现重名文件
			pictureFileName = StringUtil.newFileName(pictureFileName);
			fGoods.setPicture(pictureFileName);
			fGoodsService.onShelves(fGoods);
			// 动态获取文件路径,并复制文件到指定路径
			String path = ServletActionContext.getServletContext().getRealPath("/uploadPicture");
			File file = new File(path + "/" + pictureFileName);
			FileUtils.copyFile(picture, file);
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}
	
	// 商品下架
	public String goodsSoldOut() {
		try {
			fGoodsService.goodsSoldOut(id);
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	//通过条件查询
	public String queryByConditions() {
		try {
			int oldCategoryNum = 0;
			if (this.findValue("#session.categoryNum") != null)
				oldCategoryNum = (int) this.findValue("#session.categoryNum");
			// 获取categoryNum
			if (categoryNum != 0)
				this.setValue("#session.categoryNum", categoryNum);
			if (categoryNum == 0)
				categoryNum = (int) this.findValue("#session.categoryNum");
			// 获取以前的orderByNum
			int oldOrderByNum;
			if (this.findValue("#session.orderByNum") == null)
				oldOrderByNum = 0;
			else
				oldOrderByNum = (int) this.findValue("#session.orderByNum");
			// 获取以前及当前的pageNum
			int newPageNum;
			int oldPageNum;
			newPageNum = getPageNum();
			if (this.findValue("#session.oldPageNum") == null)
				oldPageNum = 1;
			else
				oldPageNum = (int) this.findValue("#session.oldPageNum");
			// 获取当前排序规则
			if (oldCategoryNum == categoryNum)
				ruleNum = StringUtil.getRuleNum(oldOrderByNum, orderByNum, oldPageNum, newPageNum);
			else
				ruleNum = 0;
			List<FGoods> fGoodsList = fGoodsService.queryByConditions(categoryNum, orderByNum, ruleNum, newPageNum,
					pageSize);
			this.setValue("#session.ruleNum", ruleNum);
			this.setValue("#session.orderByNum", orderByNum);
			this.setValue("#session.fGoodsList", fGoodsList);
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	//通过Id查询
	public void queryById() {
		try {
			fGoods = fGoodsService.queryById(id, times);
			String fGoodsToString = new GsonBuilder().create().toJson(fGoods);
			PrintWriter printWriter = getPrintWriter();
			
			printWriter.print(fGoods.getIntroduction());
			printWriter.flush();
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			/*if ("error".equals(e.getMessage()))
				return "error";*/
		}
		
	}
	
	//通过status查询订单，1代表上架，2代表下架
	public String queryByStatus() {
		try {
			if(status == 0)
				status = (int)this.findValue("#session.status");
			this.setValue("#session.status", status);
			String email = (String)this.findValue("#session.email");
			
			List<FGoods> fGoodsList = fGoodsService.queryByStatus(status, getPageNum(), pageSize, email);
			
			this.setValue("#session.fGoodsList", fGoodsList);
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		return "success";
	}

	// showTest
	public String showTest() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		this.setValue("#session.list", list);
		return "success";
	}
}

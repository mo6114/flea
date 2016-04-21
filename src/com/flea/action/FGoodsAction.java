package com.flea.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.flea.entity.FGoods;
import com.flea.service.FGoodsService;
import com.flea.util.StringUtil;

public class FGoodsAction extends BaseAction {

	private String name;
	private String two_level;
	private String one_level;
	private String introduction;
	private float price;
	private int amount;
	// 上传上来的图片内容及名称
	private File picture;
	private String pictureFileName;
	private FGoodsService fGoodsService;
	private FGoods fGoods;

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
}

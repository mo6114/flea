package com.flea.entity;

import java.io.Serializable;
import java.util.Date;

public class FOrderForPage implements Serializable {

	//商品名称
	private String name;
	//商品价格
	private double price;
	//买家邮箱
	private String buyerEmail;
	//卖家邮箱
	private String salerEmail;
	//交易时间
	private Date saleTime;
	//交易地点
	private String place;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getSalerEmail() {
		return salerEmail;
	}
	public void setSalerEmail(String salerEmail) {
		this.salerEmail = salerEmail;
	}
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "FOrderForPage [name=" + name + ", price=" + price + ", buyerEmail=" + buyerEmail + ", salerEmail="
				+ salerEmail + ", saleTime=" + saleTime + ", place=" + place + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerEmail == null) ? 0 : buyerEmail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((saleTime == null) ? 0 : saleTime.hashCode());
		result = prime * result + ((salerEmail == null) ? 0 : salerEmail.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FOrderForPage other = (FOrderForPage) obj;
		if (buyerEmail == null) {
			if (other.buyerEmail != null)
				return false;
		} else if (!buyerEmail.equals(other.buyerEmail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (saleTime == null) {
			if (other.saleTime != null)
				return false;
		} else if (!saleTime.equals(other.saleTime))
			return false;
		if (salerEmail == null) {
			if (other.salerEmail != null)
				return false;
		} else if (!salerEmail.equals(other.salerEmail))
			return false;
		return true;
	}
	public FOrderForPage(String name, double price, String buyerEmail, String salerEmail, Date saleTime, String place) {
		super();
		this.name = name;
		this.price = price;
		this.buyerEmail = buyerEmail;
		this.salerEmail = salerEmail;
		this.saleTime = saleTime;
		this.place = place;
	}
	public FOrderForPage() {
		super();
	}
	
	
}
/*
 * id varchar2(40) primary key , email varchar2(40) check(email like '%@%.com')
 * references fUser(email) , goodsId varchar2(40) references fGoods(id) , amount
 * number(3) default(1) not null , status number(1) default(1) check(status
 * in(0,1,2)) not null , orderTime date not null , finishTime date , mobile
 * char(11) not null , space char(100) not null , saleTime date not null
 */

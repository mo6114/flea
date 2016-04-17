package com.flea.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "fGoods")
/*
 * 缓存
 * 
 * @Cache
 */
public class FGoods implements Serializable {

	// 主键
	@Id
	@GenericGenerator(name = "gg", strategy = "uuid")
	@GeneratedValue(generator = "gg")
	@Column
	private String id;
	// 外键，卖家邮箱
	@Column
	private String email;
	// 商品名称
	@Column
	private String name;
	// 商品一级类别
	@Column
	private String one_level;
	// 商品二级类别
	@Column
	private String twe_level;
	// 商品图片名称（实际图片存在本地指定位置，非数据库）
	@Column
	private String picture;
	// 商品简介
	@Column
	private String introduction;
	// 上架时间
	@Column
	private Date timeOnShelves;
	// 商品状态（下架：0，上架：1）
	@Column
	private int status;
	// 商品数量
	@Column
	private int amount;
	// 商品价格
	@Column
	private float price;
	// 商品点击次数
	@Column
	private int times;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOne_level() {
		return one_level;
	}

	public void setOne_level(String one_level) {
		this.one_level = one_level;
	}

	public String getTwe_level() {
		return twe_level;
	}

	public void setTwe_level(String twe_level) {
		this.twe_level = twe_level;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getTimeOnShelves() {
		return timeOnShelves;
	}

	public void setTimeOnShelves(Date timeOnShelves) {
		this.timeOnShelves = timeOnShelves;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "FGoods [id=" + id + ", email=" + email + ", name=" + name + ", one_level=" + one_level + ", twe_level="
				+ twe_level + ", picture=" + picture + ", introduction=" + introduction + ", timeOnShelves="
				+ timeOnShelves + ", status=" + status + ", amount=" + amount + ", price=" + price + ", times=" + times
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((one_level == null) ? 0 : one_level.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + status;
		result = prime * result + ((timeOnShelves == null) ? 0 : timeOnShelves.hashCode());
		result = prime * result + times;
		result = prime * result + ((twe_level == null) ? 0 : twe_level.hashCode());
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
		FGoods other = (FGoods) obj;
		if (amount != other.amount)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (one_level == null) {
			if (other.one_level != null)
				return false;
		} else if (!one_level.equals(other.one_level))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (status != other.status)
			return false;
		if (timeOnShelves == null) {
			if (other.timeOnShelves != null)
				return false;
		} else if (!timeOnShelves.equals(other.timeOnShelves))
			return false;
		if (times != other.times)
			return false;
		if (twe_level == null) {
			if (other.twe_level != null)
				return false;
		} else if (!twe_level.equals(other.twe_level))
			return false;
		return true;
	}
}
/*
 * id varchar2(40) primary key , email varchar2(40) check(email like '%@%.com')
 * references fUser(email) , name varchar2(40) not null , one_level varchar2(20)
 * not null , two_level varchar2(20) not null , picture varchar2(40) not null ,
 * introduction varchar2(200) , timeOnShelves date not null , status number(1)
 * default(1) check(status in(0,1)) not null , amount number(3) default(1) not
 * null , price number(8,2) default(0.01) not null , times number(4) default(0)
 * not null
 */
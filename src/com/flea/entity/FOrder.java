package com.flea.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "fOrder")
public class FOrder implements Serializable {

	// 订单id，主键，自动生成
	@Id
	@GenericGenerator(name = "gg", strategy = "uuid")
	@GeneratedValue(generator = "gg")
	@Column
	private String id;
	// 买家email，外键
	@Column
	private String bEmail;
	// 卖家email，外键
	@Column
	private String sEmail;
	// 卖家商品id，外键
	@Column
	private String goodsId;
	// 商品数量
	@Column
	private int amount;
	// 商品状态（已取消交易：0，待交易：1，已完成交易：2）
	@Column
	private int status;
	// 下单时间
	@Column
	private Date orderTime;
	// 订单确认时间
	@Column
	private Date finishTime;
	// 交易地点
	@Column
	private String space;
	// 交易时间
	@Column
	private Date saleTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
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

	@Override
	public String toString() {
		return "FOrder [id=" + id + ", bEmail=" + bEmail + ", sEmail=" + sEmail + ", goodsId=" + goodsId + ", amount="
				+ amount + ", status=" + status + ", orderTime=" + orderTime + ", finishTime=" + finishTime + ", space="
				+ space + ", saleTime=" + saleTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((bEmail == null) ? 0 : bEmail.hashCode());
		result = prime * result + ((finishTime == null) ? 0 : finishTime.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((sEmail == null) ? 0 : sEmail.hashCode());
		result = prime * result + ((saleTime == null) ? 0 : saleTime.hashCode());
		result = prime * result + ((space == null) ? 0 : space.hashCode());
		result = prime * result + status;
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
		FOrder other = (FOrder) obj;
		if (amount != other.amount)
			return false;
		if (bEmail == null) {
			if (other.bEmail != null)
				return false;
		} else if (!bEmail.equals(other.bEmail))
			return false;
		if (finishTime == null) {
			if (other.finishTime != null)
				return false;
		} else if (!finishTime.equals(other.finishTime))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (sEmail == null) {
			if (other.sEmail != null)
				return false;
		} else if (!sEmail.equals(other.sEmail))
			return false;
		if (saleTime == null) {
			if (other.saleTime != null)
				return false;
		} else if (!saleTime.equals(other.saleTime))
			return false;
		if (space == null) {
			if (other.space != null)
				return false;
		} else if (!space.equals(other.space))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
}
/*
 * id varchar2(40) primary key , email varchar2(40) check(email like '%@%.com')
 * references fUser(email) , goodsId varchar2(40) references fGoods(id) , amount
 * number(3) default(1) not null , status number(1) default(1) check(status
 * in(0,1,2)) not null , orderTime date not null , finishTime date , mobile
 * char(11) not null , space char(100) not null , saleTime date not null
 */

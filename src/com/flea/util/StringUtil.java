package com.flea.util;

import java.util.Date;

public class StringUtil {

	private static int ruleNum;

	// 重铸文件名
	public static String newFileName(String fileName) {
		String[] tmp = fileName.split("\\.");

		return tmp[0] + new Date().getTime() + "." + tmp[1];
	}

	// 生成HQL语句(FGoods首页)
	public static String createHQL(int categoryNum, int orderByNum, int ruleNum) {
		if (orderByNum == 0)
			orderByNum = 1;
		String hql;
		if (categoryNum < 10)
			hql = "where status = 1 and one_level = ?";
		else
			hql = "where status = 1 and two_level = ?";
		hql = hql + " order by " + CategoryUtil.getOrderBy(orderByNum);
		// 1代表升序；0代表降序
		if (ruleNum != 0)
			hql = hql + " asc";
		else
			hql = hql + " desc";
		return hql;
	}

	// 根据status生成HQL,1代表上架，2代表下架(FGoods)
	public static String createHQLForFGoods(int status) {
		String hql;
		if (status == 2)
			hql = "from FGoods where status = 0 and email = ?";
		else if (status == 1)
			hql = "from FGoods where status = 1 and email = ?";
		else
			hql = "from FGoods where email = ?";
		return hql;
	}

	// 根据status生成HQL,0代表全部交易，1代表待交易商品，2代表已完成交易，3代表已取消交易(FOrder)
	public static String createHQLForFOrderSaler(int status) {
		String hql;
		if (status == 1)
			hql = "from FOrder where status = 1 and sEmail = ?";
		else if (status == 2)
			hql = "from FOrder where status = 2 and sEmail = ?";
		else if (status == 3)
			hql = "from FOrder where status = 0 and sEmail = ?";
		else
			hql = "from FOrder where sEmail = ?";
		return hql;
	}

	// 根据status生成HQL,0代表全部交易，1代表待交易商品，2代表已完成交易，3代表已取消交易(FOrder)
	public static String createHQLForFOrderBuyer(int status) {
		String hql;
		if (status == 1)
			hql = "from FOrder where status = 1 and bEmail = ?";
		else if (status == 2)
			hql = "from FOrder where status = 2 and bEmail = ?";
		else if (status == 3)
			hql = "from FOrder where status = 0 and bEmail = ?";
		else
			hql = "from FOrder where bEmail = ?";
		return hql;
	}

	public static int getRuleNum(int oldOrderByNum, int newOrderByNum, int oldPageNum, int newPageNum) {
		if (oldPageNum != newPageNum)
			return ruleNum;
		else {
			if (oldOrderByNum == newOrderByNum) {
				if (ruleNum == 1)
					ruleNum = 0;
				else
					ruleNum = 1;
			} else
				ruleNum = 0;
		}

		return ruleNum;
	}
}

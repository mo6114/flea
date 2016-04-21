package com.flea.util;

import java.util.Date;

public class StringUtil {

	// 重铸文件名
	public static String newFileName(String fileName) {
		String[] tmp = fileName.split("\\.");

		return tmp[0] + new Date().getTime() + "." + tmp[1];
	}
	
	//生成HQL语句
	public static String createHQL(int categoryNum, int orderByNum , int ruleNum) {
		if(orderByNum == 0)
			orderByNum = 4;
		String hql;
		if(categoryNum < 10)
			hql = "where one_level = ?";
		else
			hql = "where two_levle = ?";
		hql = hql + " order by " + CategoryUtil.getOrderBy(orderByNum);
		// 0代表升序；1代表降序
		if(ruleNum == 0)
			hql = hql + " asc";
		else
			hql = hql + " desc";
		return hql;
	}
}

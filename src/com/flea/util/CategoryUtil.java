package com.flea.util;

import java.util.HashMap;
import java.util.Map;

public class CategoryUtil {

	// 商品类别与排序规则Map，通过值查找相应键
	private static final Map<Integer, String> category;
	private static final Map<Integer, String> orderBy;

	static {
		// 设置category属性
		category = new HashMap<Integer, String>();
		category.put(1, "图书");
		category.put(11, "小说");
		category.put(12, "杂志");
		category.put(13, "学习资料");
		category.put(2, "服装");
		category.put(21, "上装");
		category.put(22, "下装");
		category.put(23, "整套服装");
		category.put(24, "鞋子");
		category.put(3, "电子产品");
		category.put(31, "手机");
		category.put(32, "笔记本电脑");
		category.put(33, "平板电脑");
		category.put(34, "外设");
		category.put(4, "其他");
		category.put(41, "其他");

		// 设置orderBy属性
		orderBy = new HashMap<Integer, String>();
		orderBy.put(1, "name");
		orderBy.put(2, "timeOnShelves");
		orderBy.put(3, "price");
		orderBy.put(4, "times");
	}

	public static String getCategory(int categoryNum) {
		return category.get(categoryNum);
	}

	public static String getOrderBy(int orderByNum) {
		return orderBy.get(orderByNum);
	}
}

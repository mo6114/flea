package com.flea.util;

import java.util.Date;

public class StringUtil {

	// 重铸文件名
	public static String newFileName(String fileName) {
		String[] tmp = fileName.split("\\.");

		return tmp[0] + new Date().getTime() + "." + tmp[1];
	}
}

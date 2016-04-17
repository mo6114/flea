package com.flea.test;

import org.junit.Test;

import com.flea.util.MD5Utils;

public class MD5Test {

	@Test
	public void test1() {
		System.out.println(MD5Utils.generateMD5Code("123455"));
	}
}

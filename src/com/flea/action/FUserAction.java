package com.flea.action;

import java.io.PrintWriter;

import com.flea.entity.FUser;
import com.flea.service.FUserService;
import com.flea.serviceImpl.FUserServiceImpl;

public class FUserAction extends BaseAction {

	private String email;
	private String userName;
	private String password;
	private String mobile;
	private String school;
	private FUser fUser;
	private FUserService fUserServiceImpl;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public FUserService getfUserServiceImpl() {
		return fUserServiceImpl;
	}

	public void setfUserServiceImpl(FUserService fUserServiceImpl) {
		this.fUserServiceImpl = fUserServiceImpl;
	}

	public FUser getfUser() {
		return fUser;
	}

	public void setfUser(FUser fUser) {
		this.fUser = fUser;
	}

	// 用户注册
	public String register() {
		// 将邮箱、用户名、密码、手机号、学校注入到FUser对象
		fUser.setEmail(email);
		fUser.setUserName(userName);
		fUser.setPassword(password);
		fUser.setMobile(mobile);
		fUser.setSchool(school);
		try {
			// deleteSystem.out.println(fUser);
			// 用户注册
			fUserServiceImpl.register(fUser);
		} catch (Exception e) {
			// 出现异常且为“error”时跳转到相应页面
			if ("error".equals(e.getMessage()))
				return "error";
		}
		// deleteSystem.out.println("1234");
		return "success";
	}

	// 判断邮箱是否存在
	public void emailIsExist() {
		try {
			// 获取PrintWriter对戏那个
			PrintWriter printWriter = getPrintWriter();
			// 通过邮箱查询，看是否有FUser对象返回
			if (fUserServiceImpl.queryFUserByEmail(email) == null)
				printWriter.print("true");
			else
				printWriter.println("false");

			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userNameIsExist() {
		try {
			// 获取PrintWriter对戏那个
			PrintWriter printWriter = getPrintWriter();
			// 通过用户名查询，看是否有FUser对象返回
			if (fUserServiceImpl.queryFUserByUserName(userName) == null)
				printWriter.print("true");
			else
				printWriter.println("false");

			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

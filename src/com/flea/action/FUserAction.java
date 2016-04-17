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
	
	public String register() {
		fUser.setEmail(email);
		fUser.setUserName(userName);
		fUser.setPassword(password);
		fUser.setMobile(mobile);
		fUser.setSchool(school);
		try {
			System.out.println(fUser);
			fUserServiceImpl.register(fUser);
		} catch (Exception e) {
			if("error".equals(e.getMessage()))
				return "error";
		}
		System.out.println("1234");
		return "success";
	}
	
	public void emailIsExist() {
		try {
			PrintWriter printWriter = getPrintWriter();
			
			if(fUserServiceImpl.queryFUserByEmail(email) == null)
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
			PrintWriter printWriter = getPrintWriter();

			if(fUserServiceImpl.queryFUserByUserName(userName) == null)
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

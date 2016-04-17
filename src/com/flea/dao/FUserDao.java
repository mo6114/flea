package com.flea.dao;

import org.springframework.stereotype.Component;

import com.flea.entity.FUser;

public interface FUserDao {

	public FUser queryFUserByEmail(String email);
	
	public FUser queryFUserByUserName(String userName);
	
	public void updateFUser(FUser fUser);
	
	public void insertFuser(FUser fUser);
}

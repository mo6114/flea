package com.flea.service;

import com.flea.entity.FUser;

public interface FUserService {

	public void register(FUser fUser);
	
	public FUser login(String userName , String password);
	
	public FUser queryFUserByEmail(String email);
	
	public FUser queryFUserByUserName(String userName);
}

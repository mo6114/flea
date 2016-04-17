package com.flea.service;

import com.flea.entity.FUser;

public interface FUserService {

	public void register(FUser fUser);
	
	public FUser queryFUserByEmail(String email);
	
	public FUser queryFUserByUserName(String userName);
}

package com.bjts.board.dao.login;

public interface LoginDao {

	public String valueCheckId(String id);
	
	public String valueCheckPassword(String password);

	public String getValueNickname(String id);
}

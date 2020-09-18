package com.bjts.board.service.login;

public interface LoginService {
	
	String valueCheckId(String id);
	
	Boolean valueCheckPassword(String id, String password);
}

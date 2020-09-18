package com.bjts.board.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.login.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public String valueCheckId(String id) {
		return loginDao.valueCheckId(id);
	}

	@Override
	public Boolean valueCheckPassword(String id, String password) {
		String memberPass = loginDao.valueCheckPassword(id);
		System.out.println(memberPass);
		if(memberPass.equals(password))
			return true;
		else
			return false;
	}
}

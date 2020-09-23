package com.bjts.board.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.login.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;
    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String valueCheckId(String id) {
        return loginDao.valueCheckId(id);
    }
    
	@Override
	public Boolean valueCheckPassword(String id, String password) {
		String encodePass = loginDao.valueCheckPassword(id);
		return passwordEncoder.matches(password, encodePass);
	}

	@Override
	public String getValueNickname(String id) {
		return loginDao.getValueNickname(id);
	}
}

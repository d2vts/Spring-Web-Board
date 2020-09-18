package com.bjts.board.service.member;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bjts.board.dao.member.MemberDaoImpl;
import com.bjts.board.domain.member.MemberVO;

public class MemberServiceImpl implements MemberService{

	@Override
	public void join(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemberDaoImpl memberDao = new MemberDaoImpl();
		memberDao.join(request.getParameter("userId"),request.getParameter("userPassword"),
				request.getParameter("userName"),request.getParameter("userNickname"),request.getParameter("userEmail"),
				request.getParameter("userAddress"),request.getParameter("userGender"));
	}

	
}

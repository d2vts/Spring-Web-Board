package com.bjts.board.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bjts.board.dao.member.MemberDao;
import com.bjts.board.dao.member.MemberDaoImpl;
import com.bjts.board.domain.member.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	

	@Override
	public void join(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemberDaoImpl memberDao = new MemberDaoImpl();
		memberDao.join(request.getParameter("userId"),request.getParameter("userPassword"),
				request.getParameter("userName"),request.getParameter("userNickname"),request.getParameter("userEmail"),
				request.getParameter("userAddress"),request.getParameter("userGender"));
	}

	@Override

	public String CheckPasswordMatch(String id) {
		
		String dbpassword = memberDao.CheckPasswordMatch(id);
		
		return dbpassword;
	}

	@Override
	public void update_password(String id, String newpassword) {
		
		memberDao.update_password(id, newpassword);
		
	}

	@Override
	public void delete(String id) {
		
		memberDao.delete(id);

  @Override
	public MemberVO getMemberInfo(String id) {
		return memberDao.getMemberInfo(id);
	}

	@Override
	public void update(MemberVO memberVo) {
		memberDao.update(memberVo);

	}

	
}

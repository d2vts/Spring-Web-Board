package com.bjts.board.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.member.MemberDao;
import com.bjts.board.domain.member.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void joinMemberInfo(MemberVO memberVo) {
		String encodePass = passwordEncoder.encode(memberVo.getUserPassword());
		memberVo.setUserPassword(encodePass);
		memberDao.joinMemberInfo(memberVo);
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
	}

    @Override
	public MemberVO getMemberInfo(String id) {
		return memberDao.getMemberInfo(id);
	}

	@Override
	public void update(MemberVO memberVo) {
		memberDao.update(memberVo);

	}

	
}

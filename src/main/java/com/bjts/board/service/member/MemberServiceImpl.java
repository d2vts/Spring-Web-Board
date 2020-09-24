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
		String encodePass = passwordEncoder.encode(newpassword);
		memberDao.update_password(id, encodePass);
		
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

	@Override
	public String checkMemberId(String check_id) {
		
		return memberDao.checkMemberId(check_id);
	}

	@Override
	public String checkMemberNickname(String check_nickname) {
		return memberDao.checkMemberNickname(check_nickname);
	}

	
}

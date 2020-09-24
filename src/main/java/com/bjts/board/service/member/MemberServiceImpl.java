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

	public String getMemberPassword(String id) {
		return memberDao.getMemberPassword(id);
	}

	@Override
	public void updateMemberPassword(String id, String newpassword) {
		String encodePass = passwordEncoder.encode(newpassword);
		memberDao.updateMemberPassword(id, encodePass);
		
	}

	@Override
	public void deleteMemberInfo(String id) {
		
		memberDao.deleteMemberInfo(id);
	}

    @Override
	public MemberVO getMemberInfo(String id) {
		return memberDao.getMemberInfo(id);
	}

	@Override
	public void updateMemberInfo(MemberVO memberVo) {
		memberDao.updateMemberInfo(memberVo);

	}

	@Override
	public String getMemberId(String get_id) {
		return memberDao.getMemberId(get_id);
	}

	@Override
	public String getMemberNickname(String get_nickname) {
		return memberDao.getMemberNickname(get_nickname);
	}
	
	@Override
	public Boolean checkMemberPassword(String id, String password) {
		String encodePass = memberDao.checkMemberPassword(id);
		return passwordEncoder.matches(password, encodePass);
	}

	@Override
	public String getMemberNicknameById(String id) {
		return memberDao.getMemberNicknameById(id);
	}
	
}

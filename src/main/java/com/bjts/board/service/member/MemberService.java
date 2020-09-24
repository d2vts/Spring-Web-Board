package com.bjts.board.service.member;

import com.bjts.board.domain.member.MemberVO;

public interface MemberService {
	
	void joinMemberInfo(MemberVO memberVo);

	String getMemberPassword(String id);

	MemberVO getMemberInfo(String id);

	void updateMemberInfo(MemberVO memberVo);
	
	void updateMemberPassword(String id, String newpassword);

	void deleteMemberInfo(String id);
  
	String getMemberId(String get_id);
  
	String getMemberNickname(String get_nickname);
	
	Boolean checkMemberPassword(String id, String password);

	String getMemberNicknameById(String id);
}

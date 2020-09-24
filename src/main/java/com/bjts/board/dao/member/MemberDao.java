package com.bjts.board.dao.member;

import com.bjts.board.domain.member.MemberVO;

public interface MemberDao {

	
	public void joinMemberInfo(MemberVO memberVo);
	public String getMemberPassword(String id);
	public void updateMemberPassword(String id, String newpassword);
	public void deleteMemberInfo(String id);
	public MemberVO getMemberInfo(String id);
	public void updateMemberInfo(MemberVO memberVo);
	public String getMemberId(String check_id);
	public String getMemberNickname(String check_nickname);
	public String checkMemberPassword(String id);
	public String getMemberNicknameById(String id);
}

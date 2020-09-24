package com.bjts.board.dao.member;

import com.bjts.board.domain.member.MemberVO;

public interface MemberDao {

	
	public void joinMemberInfo(MemberVO memberVo);
	public String CheckPasswordMatch(String id);
	public void update_password(String id, String newpassword);
	public void delete(String id);
	public MemberVO getMemberInfo(String id);
	public void update(MemberVO memberVo);
	public String getValueNickname(String userNickname);
	public String checkMemberId(String check_id);
	public String checkMemberNickname(String check_nickname);
}

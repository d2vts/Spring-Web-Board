package com.bjts.board.dao.member;

import com.bjts.board.domain.member.MemberVO;

public interface MemberDao {

	
	public void join(String userId, String userPassword, String userName, String userNickname,
			String userEmail, String userAddress, String userGender);

	public String CheckPasswordMatch(String id);
	public void update_password(String id, String newpassword);
	public void delete(String id);
	public MemberVO getMemberInfo(String id);
	public void update(MemberVO memberVo);
}

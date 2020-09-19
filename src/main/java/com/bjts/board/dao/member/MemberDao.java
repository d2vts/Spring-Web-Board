package com.bjts.board.dao.member;

public interface MemberDao {

	
	public void join(String userId, String userPassword, String userName, String userNickname,
			String userEmail, String userAddress, String userGender);
	
	public String CheckPasswordMatch(String id);
	
	public void update_password(String id, String newpassword);

	public void delete(String id);
}

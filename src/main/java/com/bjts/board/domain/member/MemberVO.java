package com.bjts.board.domain.member;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private int idNum;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userAddress;
	private String userGender;
	private Date cDate;
	
	public MemberVO(String userId, String userPassword, String userName, String userNickname, String userEmail,
			String userAddress, String userGender) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userGender = userGender;
	}
	
	public MemberVO(String userId, String userName, String userNickname, String userEmail,
			String userAddress, String userGender) {
		this.userId = userId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userGender = userGender;
	}

	@Override
	public String toString() {
		return "MemberVO [idNum=" + idNum + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userNickname=" + userNickname + ", userEmail=" + userEmail + ", userAddress="
				+ userAddress + ", userGender=" + userGender + ", cDate=" + cDate + "]";
	}
	

}

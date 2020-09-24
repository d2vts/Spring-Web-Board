package com.bjts.board.domain.member;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

}

package com.bjts.board.domain.member;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	
	

	/*
	 * public MemberVO(int idNum, String userId, String userPassword, String
	 * userName, String userNickname, String userEmail, String userAddress, String
	 * userGender, Date cDate) { this.idNum = idNum; this.userId = userId;
	 * this.userPassword = userPassword; this.userName = userName; this.userNickname
	 * = userNickname; this.userEmail = userEmail; this.userAddress = userAddress;
	 * this.userGender = userGender; this.cDate = cDate; }
	 */

	
	
	
	  public MemberVO(String userId, String userPassword, String userName, String
	  userNickname, String userEmail, String userAddress, String userGender) {
	  this.userId = userId; this.userPassword = userPassword; this.userName =
	  userName; this.userNickname = userNickname; this.userEmail = userEmail;
	  this.userAddress = userAddress; this.userGender = userGender; }
	 


	/*
	 * public MemberVO() {
	 * 
	 * }
	 * 
	 * public int getIdNum() { return idNum; } public void setIdNum(int idNum) {
	 * this.idNum = idNum; } public String getUserId() { return userId; } public
	 * void setUserId(String userId) { this.userId = userId; } public String
	 * getUserPassword() { return userPassword; } public void setUserPassword(String
	 * userPassword) { this.userPassword = userPassword; } public String
	 * getUserName() { return userName; } public void setUserName(String userName) {
	 * this.userName = userName; } public String getUserNickname() { return
	 * userNickname; } public void setUserNickname(String userNickname) {
	 * this.userNickname = userNickname; } public String getUserEmail() { return
	 * userEmail; } public void setUserEmail(String userEmail) { this.userEmail =
	 * userEmail; } public String getUserAddress() { return userAddress; } public
	 * void setUserAddress(String userAddress) { this.userAddress = userAddress; }
	 * public String getUserGender() { return userGender; } public void
	 * setUserGender(String userGender) { this.userGender = userGender; } public
	 * Date getcDate() { return cDate; } public void setcDate(Date cDate) {
	 * this.cDate = cDate; }
	 * 
	 * @Override public String toString() { return "MemberVO [idNum=" + idNum +
	 * ", userId=" + userId + ", userPassword=" + userPassword + ", userName=" +
	 * userName + ", userNickname=" + userNickname + ", userEmail=" + userEmail +
	 * ", userAddress=" + userAddress + ", userGender=" + userGender + ", cDate=" +
	 * cDate + "]"; }
	 */
}

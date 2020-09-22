package com.bjts.board.domain.reply;

import java.util.Date;

public class ReplyVO {

	private int re_idNum;
	private int re_boardId;
	private String re_userId;
	private String re_userNickname;
	private String re_content;
	private Date re_cDate;
	
	public ReplyVO(int re_idNum, int re_boardId, String re_userId, String re_userNickname, String re_content,
			Date re_cDate) {
		this.re_idNum = re_idNum;
		this.re_boardId = re_boardId;
		this.re_userId = re_userId;
		this.re_userNickname = re_userNickname;
		this.re_content = re_content;
		this.re_cDate = re_cDate;
	}
	
	public ReplyVO(int re_boardId, String re_userId, String re_userNickname, String re_content) {
		this.re_boardId = re_boardId;
		this.re_userId = re_userId;
		this.re_userNickname = re_userNickname;
		this.re_content = re_content;
	}

	public int getRe_idNum() {
		return re_idNum;
	}
	public void setRe_idNum(int re_idNum) {
		this.re_idNum = re_idNum;
	}
	public int getRe_boardId() {
		return re_boardId;
	}
	public void setRe_boardId(int re_boardId) {
		this.re_boardId = re_boardId;
	}
	public String getRe_userId() {
		return re_userId;
	}
	public void setRe_userId(String re_userId) {
		this.re_userId = re_userId;
	}
	public String getRe_userNickname() {
		return re_userNickname;
	}
	public void setRe_userNickname(String re_userNickname) {
		this.re_userNickname = re_userNickname;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getRe_cDate() {
		return re_cDate;
	}
	public void setRe_cDate(Date re_cDate) {
		this.re_cDate = re_cDate;
	}
	
}

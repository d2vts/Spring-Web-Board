package com.bjts.board.domain.board;

import java.util.Date;

public class BoardVO {
	private int idNum;
	private String userId;
	private String userNickname;
	private String boardTitle;
	private String boardContent;
	private int boardView;
	private Date cDate;
	
	public BoardVO() {
	}
	
	public BoardVO(int idNum, String userId, String userNickname, String boardTitle, String boardContent, int boardView,
			Date cDate) {
		this.idNum = idNum;
		this.userId = userId;
		this.userNickname = userNickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardView = boardView;
		this.cDate = cDate;
	}
	
	public BoardVO(String userId, String userNickname, String boardTitle, String boardContent, int boardView,
			Date cDate) {
		this.userId = userId;
		this.userNickname = userNickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardView = boardView;
		this.cDate = cDate;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardView() {
		return boardView;
	}

	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
}

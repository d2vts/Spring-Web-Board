package com.bjts.board.domain.reply;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {

	private int re_idNum;
	private int re_boardId;
	private String re_userId;
	private String re_userNickname;
	private String re_content;
	private Date re_cDate;
	
	public ReplyVO(int re_boardId, String re_userId, String re_userNickname, String re_content) {
		this.re_boardId = re_boardId;
		this.re_userId = re_userId;
		this.re_userNickname = re_userNickname;
		this.re_content = re_content;
	}

}

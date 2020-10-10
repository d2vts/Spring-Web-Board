package com.bjts.board.domain.board;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardVO {
	private int idNum;
	private String userId;
	private String userNickname;
	private String boardTitle;
	private String boardContent;
	private int boardView;
	private Date cDate;
	
	public BoardVO(String userId, String userNickname, String boardTitle, String boardContent, int boardView,
			Date cDate) {
		this.userId = userId;
		this.userNickname = userNickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardView = boardView;
		this.cDate = cDate;
	}

}

package com.bjts.board.service.board;

import java.util.List;

import com.bjts.board.domain.board.BoardVO;

public interface BoardService {
	
	
	List<BoardVO> getBoardInfo();

	BoardVO getBoardView(int boardNum);

	void deleteBoard(int boardNum);
}

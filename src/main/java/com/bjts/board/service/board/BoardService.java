package com.bjts.board.service.board;

import com.bjts.board.domain.board.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO boardVo);

	BoardVO getBoardInfo(int boardNum);

	void updateBoard(BoardVO boardVo);

}

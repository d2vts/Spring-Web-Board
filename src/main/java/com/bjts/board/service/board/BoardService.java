package com.bjts.board.service.board;

import java.util.HashMap;
import java.util.List;

import com.bjts.board.domain.board.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardInfoAll(HashMap<String, String> map);

	BoardVO getBoardView(int boardNum);

	void deleteBoard(int boardNum);

	void insertBoard(BoardVO boardVo);

	BoardVO getBoardInfo(int boardNum);

	void updateBoard(BoardVO boardVo);

	int getBoardCount(String field, String query);

	//void updateView(int boardNum);

}

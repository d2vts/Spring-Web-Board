package com.bjts.board.service.board;

import java.util.HashMap;
import java.util.List;

import com.bjts.board.domain.board.BoardVO;

public interface BoardService {
	
	BoardVO getBoardInfo(int boardNum);
	
	List<BoardVO> getBoardInfoAll(HashMap<String, String> map);
	
	int getBoardCount(String field, String query);

	BoardVO getBoardView(int boardNum);
	
	void deleteBoardInfo(int boardNum);

	void insertBoardInfo(BoardVO boardVo);

	void updateBoardInfo(BoardVO boardVo);

}

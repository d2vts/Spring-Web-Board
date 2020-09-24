package com.bjts.board.dao.board;


import java.util.HashMap;
import java.util.List;
import com.bjts.board.domain.board.BoardVO;

public interface BoardDao {

	BoardVO getBoardInfo(int boardNum);
	
	List<BoardVO> getBoardInfoAll(HashMap<String, String> map);
	
	int getBoardCount(String field, String query);

	BoardVO getBoardView(int boardNum);

	void insertBoardInfo(BoardVO boardVo);
	
	void updateBoardInfo(BoardVO boardVo);
	
	void deleteBoardInfo(int boardNum);
	
}

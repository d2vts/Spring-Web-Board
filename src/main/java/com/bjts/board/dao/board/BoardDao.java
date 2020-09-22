package com.bjts.board.dao.board;


import java.util.List;
import com.bjts.board.domain.board.BoardVO;

public interface BoardDao {

	List<BoardVO> getBoardInfoAll();

	BoardVO getBoardView(int boardNum);

	void deleteBoard(int boardNum);
	void insertBoard(BoardVO boardVo);

	BoardVO getBoardInfo(int boardNum);

	void updateBoard(BoardVO boardVo);

}

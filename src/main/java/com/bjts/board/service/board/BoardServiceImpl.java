package com.bjts.board.service.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.board.BoardDao;
import com.bjts.board.domain.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;



	@Override
	public BoardVO getBoardInfo(int boardNum) {
		return boardDao.getBoardInfo(boardNum);
	}

	@Override
	public List<BoardVO> getBoardInfoAll(HashMap<String, String> map) {
		return boardDao.getBoardInfoAll(map);
	}
	
	@Override
	public int getBoardCount(String field, String query) {
		return boardDao.getBoardCount(field, query);
	}
	
	@Override
	public BoardVO getBoardView(int boardNum) {
		BoardVO boardVO = boardDao.getBoardView(boardNum);
		return boardVO;
	}
	
	@Override
	public void insertBoardInfo(BoardVO boardVo) {
		boardDao.insertBoardInfo(boardVo);
	}

	@Override
	public void updateBoardInfo(BoardVO boardVo) {
		boardDao.updateBoardInfo(boardVo);
	}

	@Override
	public void deleteBoardInfo(int boardNum) {
		boardDao.deleteBoardInfo(boardNum);
	}
	


}

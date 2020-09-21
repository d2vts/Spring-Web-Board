package com.bjts.board.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.board.BoardDao;
import com.bjts.board.domain.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> getBoardInfo() {
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = boardDao.getBoardInfo();
		
		return boardlist;
	}

	@Override
	public BoardVO getBoardView(int boardNum) {
		BoardVO boardVO = boardDao.getBoardView(boardNum);
		return boardVO;
	}

	@Override
	public void deleteBoard(int boardNum) {
		
		boardDao.deleteBoard(boardNum);
		
	}

}

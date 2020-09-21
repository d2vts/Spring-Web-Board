package com.bjts.board.dao.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.board.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{

	private static final String namespace="com.bjts.board.dao.board.BoardDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardVO boardVo) {
		sqlSession.insert(namespace + ".insertBoard", boardVo);
	}

	@Override
	public BoardVO getBoardInfo(int boardNum) {
		return sqlSession.selectOne(namespace + ".getBoardInfo", boardNum);
	}

	@Override
	public void updateBoard(BoardVO boardVo) {
		sqlSession.update(namespace + ".updateBoard", boardVo);
	}

}

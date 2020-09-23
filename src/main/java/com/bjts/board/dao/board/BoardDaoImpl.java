package com.bjts.board.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjts.board.domain.board.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	private static final String namespace="com.bjts.board.dao.board.BoardDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	//getBoardInfo() 수정
	@Override
	public List<BoardVO> getBoardInfoAll(HashMap<String, String> map) {
		String field = map.get("field");
		if(!field.equals("titleNick")) {
			System.out.println("here");
			return sqlSession.selectList(namespace + ".getBoardInfoAll", map);
		}
		else {
			map.put("userNickname", "userNickname");
			map.put("boardTitle", "boardTitle");
			return sqlSession.selectList(namespace + ".getBoardInfoTitleNick", map);
		}
	}

	@Override
	@Transactional
	public BoardVO getBoardView(int boardNum) {
				sqlSession.update(namespace + ".updateView",boardNum);
		return sqlSession.selectOne(namespace + ".getBoardView", boardNum);
	}

	@Override
	public void deleteBoard(int boardNum) {
		sqlSession.delete(namespace + ".deleteBoard", boardNum);
  }
	@Override
	public void insertBoard(BoardVO boardVo) {
		sqlSession.insert(namespace + ".insertBoard", boardVo);
	}
	//getBoardInfo() 수정

	@Override
	public BoardVO getBoardInfo(int boardNum) {
		return sqlSession.selectOne(namespace + ".getBoardInfo", boardNum);
	}

	@Override
	public void updateBoard(BoardVO boardVo) {
		sqlSession.update(namespace + ".updateBoard", boardVo);
	}

	@Override
	public int getBoardCount(String field, String query) {
		HashMap<String , String> map = new HashMap<String , String>();
		if(!field.equals("titleNick")) {
			map.put("field", field);
			map.put("query", query);
			return sqlSession.selectOne(namespace + ".getBoardCount", map);
		}
		else {
			map.put("query", query);
			map.put("userNickname", "userNickname");
			map.put("boardTitle", "boardTitle");
			return sqlSession.selectOne(namespace + ".getBoardCountTitleNick", map);
		}
	}

	/*
	 * @Override public void updateView(int boardNum) {
	 * sqlSession.update(namespace + ".updateView",boardNum);
	 * 
	 * }
	 */

}

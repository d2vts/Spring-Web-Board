package com.bjts.board.dao.reply;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.reply.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	private static final String namespace="com.bjts.board.dao.reply.ReplyDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertReply(ReplyVO replyVO) {
		sqlSession.insert(namespace + ".insertReply", replyVO);
	}

}

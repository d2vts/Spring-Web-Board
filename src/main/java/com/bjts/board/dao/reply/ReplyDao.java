package com.bjts.board.dao.reply;

import java.util.List;

import com.bjts.board.domain.reply.ReplyVO;

public interface ReplyDao {

	List<ReplyVO> getReplyView(int boardNum);

	void insertReplyInfo(ReplyVO replyVO);

	void updateReplyInfo(ReplyVO replyVO);
	
	void deleteReplyInfo(int boardNum);
}

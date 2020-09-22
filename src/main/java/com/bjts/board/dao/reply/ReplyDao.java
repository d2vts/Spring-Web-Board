package com.bjts.board.dao.reply;

import java.util.List;

import com.bjts.board.domain.reply.ReplyVO;

public interface ReplyDao {

	List<ReplyVO> getReplyView(int boardNum);

	void deleteReply(int boardNum);

	void insertReply(ReplyVO replyVO);

}

package com.bjts.board.service.reply;

import java.util.List;

import com.bjts.board.domain.reply.ReplyVO;

public interface ReplyService {

	List<ReplyVO> getReplyView(int boardNum);

	void insertReplyInfo(ReplyVO replyVO);
	
	void updateReplyInfo(ReplyVO replyVO);
	
	void deleteReplyInfo(int boardNum);

}

package com.bjts.board.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjts.board.domain.board.BoardVO;
import com.bjts.board.domain.reply.ReplyVO;
import com.bjts.board.service.board.BoardService;
import com.bjts.board.service.reply.ReplyService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,  Model model) {
		logger.info("list()-GET");
		String page = request.getParameter("page");
		String field = request.getParameter("field");
		String query = request.getParameter("query");
		System.out.println(field + " / " + query);
		if(page == "" || page == null)
			page = "1";
		if(field == "" || field == null)
			field = "BOARDTITLE";
		if(query == null)
			query = "";
		int n_page = Integer.parseInt(page);
		int startNum = 1+(n_page-1)*10;
		int lastNum = n_page*10;
		HashMap<String , String> map = new HashMap<String , String>();
		map.put("field", field);
		map.put("query", query);
		map.put("startNum", String.valueOf(startNum));
		map.put("lastNum", String.valueOf(lastNum));
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = boardService.getBoardInfoAll(map);
		int count = boardService.getBoardCount(field, query);
		model.addAttribute("boardInfo", boardlist);
		model.addAttribute("page", page);
		model.addAttribute("count", count);
		return "board/list_board";
	}
	
	@RequestMapping("list/update_board")
	public String update_board(BoardVO boardVo, @RequestParam("boardNum") int boardNum, Model model) {
		logger.info("update_board()-GET");
		boardVo = boardService.getBoardInfo(boardNum);
		System.out.println(boardVo);
		model.addAttribute("board", boardVo);
		return "board/update_board";
	}
	
	@RequestMapping(value="list/update_board", method = RequestMethod.POST)
	public String update_board(BoardVO boardVo, Model model, HttpServletRequest request) {
		logger.info("update_board()-GET");
		boardService.updateBoardInfo(boardVo);
		return "redirect:/list";
	}
	
	@RequestMapping("list/write_board")
	public String write_board(Model model) {
		logger.info("write_board()-GET");
		return "board/write_board";
	}
	
	@RequestMapping("list/view")
	public String view(@RequestParam("boardNum") int boardNum, Model model, HttpSession session) {
		logger.info("view()-GET");
		//boardService.updateView(boardNum);
		String session_nic = (String) session.getAttribute("userNickname");
		List<ReplyVO> replylist = new ArrayList<ReplyVO>();
		BoardVO boardVO = boardService.getBoardView(boardNum);
		replylist = replyService.getReplyView(boardNum);
		model.addAttribute("board",boardVO);
		model.addAttribute("replyInfo",replylist);
		model.addAttribute("userNickname", session_nic);
		return "board/view_board";
	}
	
	@RequestMapping(value="list/view/write_reply", method = RequestMethod.POST)
    public String write_reply(ReplyVO replyVO,HttpServletRequest request, Model model, HttpSession session) {
        logger.info("view()-POST");
        replyVO.setRe_userId((String)session.getAttribute("userId"));
        replyVO.setRe_userNickname((String)session.getAttribute("userNickname"));
        replyService.insertReplyInfo(replyVO);
        return "redirect:/list/view?boardNum="+replyVO.getRe_boardId(); // 매핑오류나면 볼것
    }
	
	@RequestMapping("list/delete_board")
	public String delete_board(@RequestParam("boardNum") int boardNum, Model model) {
		logger.info("delete_board()-GET");
		boardService.deleteBoardInfo(boardNum);
		return "redirect:/list";
	}
	
	@RequestMapping("list/delete_reply")
	public String delete_reply(@RequestParam("boardNum") int boardNum, @RequestParam("replyNum") int replyNum, Model model) {
		logger.info("delete_reply()-GET");
		String numBoard = String.valueOf(boardNum);
		replyService.deleteReplyInfo(replyNum);
		return "redirect:/list/view?boardNum="+numBoard;
	}
	
	@RequestMapping(value="list/write_board", method = RequestMethod.POST)
	public String write_board(BoardVO boardVo, HttpServletRequest request, Model model, HttpSession session) {
		logger.info("write_board()-POST");
		boardVo.setUserId((String)session.getAttribute("userId"));
		boardVo.setUserNickname((String)session.getAttribute("userNickname"));
		boardVo.setBoardView(0); 
		boardService.insertBoardInfo(boardVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="list/update_reply", method = RequestMethod.POST)
	public String update_reply(ReplyVO replyVO, Model model, HttpServletRequest request) {
		replyService.updateReplyInfo(replyVO);
		return"redirect:/list/view?boardNum="+String.valueOf(replyVO.getRe_boardId());
	}
	
}

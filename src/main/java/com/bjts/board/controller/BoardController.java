package com.bjts.board.controller;

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
import com.bjts.board.domain.member.MemberVO;
import com.bjts.board.service.board.BoardService;
import com.bjts.board.service.login.LoginService;
import com.bjts.board.service.member.MemberService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardSerivce;
	
	@RequestMapping("list")
	public String list(Model model) {
		logger.info("list()-GET");
		
		return "board/list_board";
	}
	
	@RequestMapping("list/modify_board")
	public String modify_board(BoardVO boardVo, @RequestParam("boardNum") int boardNum, Model model) {
		logger.info("modify_board()-GET");
		boardVo = boardSerivce.getBoardInfo(boardNum);
		System.out.println(boardVo);
		model.addAttribute("board", boardVo);
		return "board/modify_board";
	}
	
	@RequestMapping(value="list/modify_board", method = RequestMethod.POST)
	public String modify_board(BoardVO boardVo, Model model, HttpServletRequest request) {
		logger.info("modify_board()-GET");
		boardVo.setIdNum(Integer.parseInt(request.getParameter("boardNum")));
		boardVo.setBoardTitle(request.getParameter("boardTitle"));
		boardVo.setBoardContent(request.getParameter("boardContent"));
		boardSerivce.updateBoard(boardVo);
		return "redirect:/list";
	}
	
	@RequestMapping("list/write_board")
	public String write_board(Model model) {
		logger.info("write_board()-GET");
		
		return "board/write_board";
	}
	
	@RequestMapping(value="list/write_board", method = RequestMethod.POST)
	public String write_board(BoardVO boardVo, HttpServletRequest request, Model model, HttpSession session) {
		logger.info("write_board()-POST");
		boardVo.setUserId((String)session.getAttribute("userId"));
		boardVo.setUserNickname((String)session.getAttribute("userNickname"));
		boardVo.setBoardTitle(request.getParameter("boardTitle"));
		boardVo.setBoardContent(request.getParameter("boardContent"));
		boardVo.setBoardView(1); 
		boardSerivce.insertBoard(boardVo);
		return "redirect:/list";
	}
	
}

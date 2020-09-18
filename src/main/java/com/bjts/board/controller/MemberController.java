package com.bjts.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjts.board.dao.member.MemberDao;
import com.bjts.board.dao.member.MemberDaoImpl;
import com.bjts.board.service.member.MemberService;

import temp.Constant;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	MemberService service;
	public JdbcTemplate template;
	MemberDaoImpl memberDaoImpl;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	public void setDaoImpl(MemberDaoImpl memberDaoImpl) {
		
		this.memberDaoImpl = memberDaoImpl;
		// TODO Auto-generated method stub

	}
	
	@RequestMapping("/sign_up")
	public String sign_up(Model model) {
		logger.info("sign_up()-GET");
		
		
		
		return "sign_up";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/sign_up")
	public String sign_up(HttpServletRequest request, Model model) {
		logger.info("sign_up()-POST");
		
		MemberDao memberdao = sqlSession.getMapper(MemberDao.class);
		memberdao.join(request.getParameter("userId"),request.getParameter("userPassword"),
				request.getParameter("userName"),request.getParameter("userNickname"),request.getParameter("userEmail"),
				request.getParameter("userAddress"),request.getParameter("userGender"));
		return "redirect:/";
	}
}

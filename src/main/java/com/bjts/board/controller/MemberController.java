package com.bjts.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.bjts.board.domain.member.MemberVO;
import com.bjts.board.service.member.MemberService;

import temp.Constant;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	public JdbcTemplate template;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/sign_up")
	public String sign_up(Model model) {
		logger.info("sign_up()-GET");
		
		return "sign_up";
	}
	
	@RequestMapping("mypage")
	public String mypage(Model model) {
		logger.info("mypage()-GET");
		return "mypage";
	}
	
	@RequestMapping("mypage/modify_member")
	public String modify_member(MemberVO memberVo, HttpSession session, Model model) {
		logger.info("modify_member()-GET");
		String session_id = (String) session.getAttribute("userId");
		memberVo = memberService.getMemberInfo(session_id);
		System.out.println(memberVo.getUserName());
		model.addAttribute("member", memberVo);
		return "modify_member";
	}
	
	@RequestMapping(value="mypage/modify", method = RequestMethod.POST)
	public String modify(MemberVO memberVo, HttpServletRequest request, Model model) {
		logger.info("modify()-POST");
		memberVo.setUserId((request.getParameter("userId")));
		memberVo.setUserNickname((request.getParameter("userNickname")));
		memberVo.setUserEmail((request.getParameter("userEmail")));
		memberVo.setUserAddress((request.getParameter("userAddress")));
		memberService.update(memberVo);
		return "redirect:/mypage";
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

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
import com.bjts.board.service.member.MemberService;

import temp.Constant;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@Autowired
	private MemberService service;
	
	
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
	
	@RequestMapping("/mypage")
	public String mypage(Model model) {
		
		return "/mypage";
	}
	
	@RequestMapping("/mypage/change_password")
	public String change_password(Model model) {
		logger.info("change_password() -GET");
		
		return "change_password";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/mypage/change_password")
	public String change_password(HttpServletRequest request, Model model, HttpSession session) {
		
		String password = request.getParameter("userPassword");
		String newpassword = request.getParameter("newPassword");
		String id = (String) session.getAttribute("id");
		String dbpassword;
		if(password.equals("") || password==null) {
			model.addAttribute("value_status","empty");
			return "redirect:change_password";
		}
		else { // 이제 해야 할것은 서비스 이용해서  비밀번호 값 일치하는지 체크
			dbpassword = service.CheckPasswordMatch(id);
			// dbpassword에는 현재 세션의 아이디값의 패스워드가 들어가있음
			if(password.equals(dbpassword)) {
				
				service.update_password(id,newpassword);
				
				return "redirect:/mypage";
			}
			else {
				model.addAttribute("value_status", "notMatch");
				return "redirect:change_password";
			}
			
			
			
		}
	}
	
	@RequestMapping("mypage/delete_member")
	public String delete(Model model) {
		
		return"delete_member";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/mypage/delete_member")
	public String delete(HttpServletRequest request, Model model, HttpSession session) {
		String password = request.getParameter("password");
		String id = (String) session.getAttribute("id");
		String dbpassword;
		
		dbpassword = service.CheckPasswordMatch(id);
		
		if(password.equals(dbpassword)) {
			service.delete(id);
			
			return "home";
		}
		else {
			model.addAttribute("value_status", "notMatch");
			return "redirect:delete_member";
		}
		
	}
	
	
	
	
	
}

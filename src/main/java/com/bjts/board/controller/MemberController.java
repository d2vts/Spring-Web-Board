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

import com.bjts.board.domain.member.MemberVO;
import com.bjts.board.service.login.LoginService;
import com.bjts.board.service.member.MemberService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/sign_up")
	public String sign_up(Model model) {
		logger.info("sign_up()-GET");
		
		return "member/sign_up";
	}
	
	@RequestMapping("mypage")
	public String mypage(Model model) {
		logger.info("mypage()-GET");
		return "member/mypage";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
	
		return "member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, HttpSession session) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id.equals("") || password.equals("")) {
			session.setAttribute("error", "로그인 실패 했습니다.");
		}
		else {
			if(id.equals(loginService.valueCheckId(id))) {
				if(loginService.valueCheckPassword(id, password)) {
					session.setAttribute("userId", id);
					session.setAttribute("userNickname", loginService.getValueNickname(id));
					model.addAttribute("success", "성공");
					return "home";
				}
				else {
					model.addAttribute("success", "실패");
					return "member/login_test";
				}
			}
			else {
				model.addAttribute("success", "실패");
				return "member/login_test";
			}
		}
		return "member/login_test";
	}
  
	@RequestMapping("mypage/modify_member")
	public String modify_member(MemberVO memberVo, HttpSession session, Model model) {
		logger.info("modify_member()-GET");
		String session_id = (String) session.getAttribute("userId");
		memberVo = memberService.getMemberInfo(session_id);
		model.addAttribute("member", memberVo);
		return "member/modify_member";
	}
	
	@RequestMapping(value="mypage/modify_member", method = RequestMethod.POST)
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
	public String sign_up(MemberVO memberVo, HttpServletRequest request, Model model) {
		logger.info("sign_up()-POST");
		memberVo.setUserId((request.getParameter("userId")));
		memberVo.setUserPassword((request.getParameter("userPassword")));
		memberVo.setUserName((request.getParameter("userName")));
		memberVo.setUserNickname((request.getParameter("userNickname")));
		memberVo.setUserEmail((request.getParameter("userEmail")));
		memberVo.setUserAddress((request.getParameter("userAddress")));
		memberVo.setUserGender((request.getParameter("userGender")));
		memberService.joinMemberInfo(memberVo);
		return "redirect:/";
	}
	
	@RequestMapping("/mypage/change_password")
	public String change_password(Model model) {
		logger.info("change_password() -GET");
		
		return "member/change_password";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/mypage/change_password")
	public String change_password(HttpServletRequest request, Model model, HttpSession session) {
		
		String password = request.getParameter("userPassword");
		String newpassword = request.getParameter("newPassword");
		String id = (String) session.getAttribute("userId");
		String dbpassword;
		if(password.equals("") || password==null) {
			model.addAttribute("value_status","empty");
			return "redirect:change_password";
		}
		else { // 이제 해야 할것은 서비스 이용해서  비밀번호 값 일치하는지 체크
			dbpassword = memberService.CheckPasswordMatch(id);
			// dbpassword에는 현재 세션의 아이디값의 패스워드가 들어가있음
			if(password.equals(dbpassword)) {
				
				memberService.update_password(id,newpassword);
				
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
		
		return"member/delete_member";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/mypage/delete_member")
	public String delete(HttpServletRequest request, Model model, HttpSession session) {
		String password = request.getParameter("password");
		String id = (String) session.getAttribute("userId");
		String dbpassword;
		
		dbpassword = memberService.CheckPasswordMatch(id);
		
		if(password.equals(dbpassword)) {
			memberService.delete(id);
			
			return "home";
		}
		else {
			model.addAttribute("value_status", "notMatch");
			return "redirect:delete_member";
		}
		
	}
	
}

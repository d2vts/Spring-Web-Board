package com.bjts.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjts.board.domain.member.MemberVO;
import com.bjts.board.service.login.LoginService;
import com.bjts.board.service.member.MemberService;
import com.bjts.board.validator.MemberValidator;

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
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("userId");
		return "redirect:/";
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
					return "redirect:/";
				}
				else {
					return "member/login";
				}
			}
			else {
				return "member/login";
			}
		}
		return "member/login";
	}
  
	@RequestMapping("mypage/modify_member")
	public String modify_member(MemberVO memberVo, HttpSession session, Model model) {
		logger.info("modify_member()-GET");
		String session_id = (String) session.getAttribute("userId");
		memberVo = memberService.getMemberInfo(session_id);
		System.out.println(memberVo.getUserName() + " / " + memberVo.getCDate());
		model.addAttribute("member", memberVo);
		return "member/modify_member";
	}
	
	@RequestMapping(value="mypage/modify_member", method = RequestMethod.POST)
	public String modify(MemberVO memberVo, HttpServletRequest request, HttpSession session, Model model) {
		logger.info("modify()-POST");
		memberService.update(memberVo);
		session.setAttribute("userNickname", request.getParameter("userNickname"));
		return "redirect:/mypage";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/sign_up")
	public String sign_up(@Valid MemberVO memberVo, Model model, Errors error){
		logger.info("sign_up()-POST");
		String db_userId = loginService.valueCheckId(memberVo.getUserId());
		String db_userNickname = memberService.getValueNickname(memberVo.getUserNickname());
		new MemberValidator().validate(memberVo, error);
		if(db_userId != null)
			error.rejectValue("userId", "userIdDuplicated");
		if(db_userNickname != null)
			error.rejectValue("userNickname", "userNicknameDuplicated");
		if(error.hasErrors()) {
			model.addAttribute("memberVo", memberVo);
			return "member/sign_up";
		}
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
		if(password.equals("") || password==null) {
			model.addAttribute("value_status","empty");
			return "redirect:change_password";
		}
		else { // 이제 해야 할것은 서비스 이용해서  비밀번호 값 일치하는지 체크
			// dbpassword에는 현재 세션의 아이디값의 패스워드가 들어가있음
			if(loginService.valueCheckPassword(id, password)) {
				
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
	
	@RequestMapping(method = RequestMethod.POST, value="/check_id_ajax")
	@ResponseBody
	public String check_id_ajax(MemberVO memberVO) {
		logger.info("check_id_ajax()-POST");
		String check_id = memberVO.getUserId();
		return memberService.checkMemberId(check_id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/check_nickname_ajax")
	@ResponseBody
	public String check_nickname_ajax(MemberVO memberVO) {
		logger.info("check_nickname_ajax()-POST");
		String check_nickname = memberVO.getUserNickname();
		return memberService.checkMemberNickname(check_nickname);
	}
	
	
	
}

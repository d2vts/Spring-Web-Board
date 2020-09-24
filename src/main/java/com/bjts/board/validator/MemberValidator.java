package com.bjts.board.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bjts.board.domain.member.MemberVO;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVo = (MemberVO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNickname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAddress", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userGender", "required");
		if(memberVo.getUserId().length() < 2 || memberVo.getUserId().length() > 10) {
			errors.rejectValue("userId", "userIdLength");
		}
		if(memberVo.getUserPassword().length() < 8 || memberVo.getUserPassword().length() > 20) {
			errors.rejectValue("userPassword", "userPasswordLength");
		}
		if(memberVo.getUserName().length() < 2 || memberVo.getUserName().length() > 10) {
			errors.rejectValue("userName", "userNameLength");
		}
		if(memberVo.getUserNickname().length() < 2 || memberVo.getUserNickname().length() > 8) {
			errors.rejectValue("userNickname", "userNicknameLength");
		}
		if(memberVo.getUserAddress().length() < 2 || memberVo.getUserAddress().length() > 40) {
			errors.rejectValue("userAddress", "userAddressLength");
		}
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/sign_up.js"></script>
</head>
<body>
	<h1>회원가입</h1>



	<form:form commandName="memberVO">
아이디 : <input type="text" name="userId" id="userId"
			value="${memberVo.userId }">
		<p id="sign-check-info-id">&nbsp;</p>
		<form:errors path="userId" cssStyle="color:red;" />
		<br />
비밀번호 : <input type="password" name="userPassword" id="userPassword">
		<p id="sign-check-info-pw">&nbsp;</p>
		<form:errors path="userPassword" cssStyle="color:red;" />
		<br />
비밀번호 확인 : <input type="password" id="userPassword2">
		<p id="sign-check-info-pw2">&nbsp;</p>
		<br />
이름 : <input type="text" name="userName" id="userName"
			value="${memberVo.userName }">
		<p id="sign-check-info-name">&nbsp;</p>
		<form:errors path="userName" cssStyle="color:red;" />
		<br />
닉네임 : <input type="text" name="userNickname" id="userNickname"
			value="${memberVo.userNickname }">
		<p id="sign-check-info-nick">&nbsp;</p>
		<form:errors path="userNickname" cssStyle="color:red;" />
		<br />
이메일 : <input type="email" name="userEmail" id="userEmail"
			value="${memberVo.userEmail }">
		<p id="sign-check-info-email">&nbsp;</p>
		<form:errors path="userEmail" cssStyle="color:red;" />
		<br />
주소 :  <select id="userAddress" name="userAddress">
            <option value="서울특별시" selected>서울특별시</option>
            <option value="대구광역시">대구광역시</option>
            <option value="부산광역시">부산광역시</option>
      </select>
	   <p id="sign-check-info-addr">&nbsp;</p>
	   <br />
		
성별 : <input type="radio" name="userGender" id="userGender" value="남"checked>남
	 <input type="radio" name="userGender" id="userGender" value="여">여
		<p id="sign-check-info-gender">&nbsp;</p>
		<br />
	  <input type="submit" value="전송">
	</form:form>

</body>
</html>
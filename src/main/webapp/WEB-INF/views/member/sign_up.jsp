<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
아이디 : <input type="text" name="userId" id="userId" value="${memberVo.userId }"> 
<form:errors path="userId" cssStyle="color:red;"/><br/>
비밀번호 : <input type="password" name="userPassword">
<form:errors path="userPassword" cssStyle="color:red;"/><br/>
비밀번호 : <input type="password" name="userPassword">
<form:errors path="userPassword" cssStyle="color:red;"/><br/>
이름 : <input type="text" name="userName" value="${memberVo.userName }">
<form:errors path="userName" cssStyle="color:red;"/><br/>
닉네임 : <input type="text" name="userNickname" value="${memberVo.userNickname }">
<form:errors path="userNickname" cssStyle="color:red;"/><br/>
이메일 : <input type="email" name="userEmail" value="${memberVo.userEmail }">
<form:errors path="userEmail" cssStyle="color:red;"/><br/>
주소 : <input type="text" name="userAddress" value="${memberVo.userAddress }">
<form:errors path="userAddress" cssStyle="color:red;"/><br/>
성별 : <input type="text" name="userGender" value="${memberVo.userGender }">
<form:errors path="userGender" cssStyle="color:red;"/><br/>
</form:form>
  
	<form action="sign_up" method="POST">

		아이디 : <input type="text" id="userId" name="userId"><br />
		<p id="sign-check-info-id">&nbsp;</p>
		비밀번호 : <input type="password" id="userPassword" name="userPassword"><br />
		<p id="sign-check-info-pw">&nbsp;</p>
		비밀번호 확인 : <input type="password" id="userPassword2"><br />
		<p id="sign-check-info-pw2">&nbsp;</p>
		이름 : <input type="text" id="userName" name="userName"><br />
		<p id="sign-check-info-name">&nbsp;</p>
		닉네임 : <input type="text" id="userNickname" name="userNickname"><br />
		<p id="sign-check-info-nick">&nbsp;</p>
		이메일 : <input type="email" id="userEmail" name="userEmail"><br />
		<p id="sign-check-info-email">&nbsp;</p>
		주소 : <input type="text" id="userAddress" name="userAddress"><br />
		<p id="sign-check-info-addr">&nbsp;</p>
		성별 : <input type="text" id="userGender" name="userGender"><br />
		<p id="sign-check-info-gender">&nbsp;</p>
		<input type="submit" value="전송">






	</form>


</body>
</html>
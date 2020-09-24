<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원가입 </h1>



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

<input type="submit" value="전송">




</form:form>


</body>
</html>
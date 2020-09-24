<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<form:form commandName="memberVO">
아이디 : <input type="text" name="userId" id="userId"
			value="${memberVo.userId } " readonly>
		<p id="sign-check-info-id">&nbsp;</p>
		<form:errors path="userId" cssStyle="color:red;" />
		<br />
이름 : <input type="text" name="userName" id="userName"
			value="${memberVo.userName }" readonly>
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
            	<option value="서울특별시" <c:if test="${memberVo.userAddress == '서울특별시' }">selected</c:if>>서울특별시</option>
            	<option value="대구광역시" <c:if test="${memberVo.userAddress == '대구광역시' }">selected</c:if>>대구광역시</option>
            	<option value="부산광역시" <c:if test="${memberVo.userAddress == '부산광역시' }">selected</c:if>>부산광역시</option>
      </select>
	   <p id="sign-check-info-addr">&nbsp;</p>
	   <br />
		
성별 : <input type="radio" name="userGender" id="userGender" value="남" <c:if test="${memberVo.userGender == '남' }">checked</c:if> readonly>남
	 <input type="radio" name="userGender" id="userGender" value="여" <c:if test="${memberVo.userGender == '여' }">checked</c:if> readonly>여
		<p id="sign-check-info-gender">&nbsp;</p>
		<br />
	  <input type="submit" value="전송">
	</form:form>
</body>
</html>
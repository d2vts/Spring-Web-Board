<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/modify_member.js"></script>
</head>
<body>
	<form action="modify_member" method="POST" onsubmit="return submitCheck()">
		아이디 : <input type="text" name="userId" value="${member.userId }" readonly> <br/>
		이름 : <input type="text" name="userName" value="${member.userName }" readonly><br/>
		닉네임 : <input type="text" name="userNickname" id="userNickname"value="${member.userNickname }" onkeyup="noSpaceForm(this)" required><br/>
		<p id="sign-check-info-nick"></p>
		이메일 : <input type="email" name="userEmail" id="userEmail" value="${member.userEmail}" onkeyup="noSpaceForm(this)" required><br/>
		<p id="sign-check-info-email"></p>
		주소 : <input type="text" name="userAddress" value="${member.userAddress }"><br/>
		성별 : <input type="text" name="userGender" value="${member.userGender }" readonly><br/>
		<input type="submit" value="전송">
	</form>
</body>
</html>
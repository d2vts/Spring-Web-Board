<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>

<form action="/board/mypage/change_password" method="POST">
	현재 비밀번호  <input type ="password" name="userPassword">
	새 비밀번호  <input type ="password" name="newPassword">
	새 비밀번호 확인  <input type ="password" name="newPassword_check">
	<input type="submit" value="비밀번호 변경">
</form>
</body>
</html>
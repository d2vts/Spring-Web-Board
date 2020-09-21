<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE MEMBER</title>
</head>
<body>

<form action="/board/mypage/delete_member" method="POST">
	비밀번호 확인 <br/>
	<input type="password" name="password">
	<input type="submit" value="회원탈퇴">



</form>
</body>
</html>
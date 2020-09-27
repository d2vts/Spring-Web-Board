<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="/board/css/member.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/sign_up.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="login-box">
		<h1>Modify-Password</h1>
		<form action="/board/mypage/change_password" method="POST">
			<div class="textbox">
				현재 비밀번호  <input type ="password" name="userPassword">
			</div>
			<div class="textbox">
				새 비밀번호  <input type ="password" name="newPassword">
			</div>
			<div class="textbox">
				새 비밀번호 확인  <input type ="password" name="newPassword_check">
			</div>
			<input type="submit" class="submit-btn" value="비밀번호 변경">
		</form>
	</div>
</body>
</html>
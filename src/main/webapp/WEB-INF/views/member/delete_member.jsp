<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE MEMBER</title>
<link rel="stylesheet" href="/board/css/member.css"></head>
<body>
	<div class="login-box">
		<h1>Secession</h1>
		<form action="/board/mypage/delete_member" method="POST">
			<div class="textbox">
				<input type="password" name="password" placeholder="UserPassword">
			</div>
			<input type="submit" class="submit-btn" value="회 원 탈 퇴">
		</form>
	</div>
</body>
</html>
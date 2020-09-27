<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/member.css">
</head>
<body>
	<div class="login-box">
		<h1>Login</h1>
		<form action="login" method="post">
			<div class="textbox">
				<i class="fas fa-user"></i>
				<input type="text" name="id" placeholder="UserId" autocomplete="off">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i>
				<input type="password" name="password" placeholder="Password">
			</div>
			<input type="submit" class="submit-btn" value="로 그 인">
		</form>
			<Button class="submit-btn" onclick="location.href='sign_up' ">회 원 가 입</Button>
	</div>
</body>
</html>

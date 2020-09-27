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
<header>
		<div class="container">
			<h1>Spring Project</h1>
			<nav>
				<a href="list">게시판</a>
				<c:if test="${userId == null}">
					<a href="login">로그인</a>
					<a href="sign_up">회원가입</a>
				</c:if>
				<c:if test="${userId != null}">
					<a href="logout">로그아웃</a>
					<a href="mypage">마이페이지</a>
				</c:if>
				<a href="https://github.com/bj-ts/Spring-Web-Board">GITHUB</a>
			</nav>
		</div>
	</header>
	<div class="login-box">
		<h1>Login</h1>
		<form action="login" method="post">
			<div class="textbox">
				<i class="fas fa-user"></i>
				<input type="text" name="id" placeholder="UserId" autocomplete="off" maxlength="50">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i>
				<input type="password" name="password" placeholder="Password" maxlength="20">
			</div>
			<input type="submit" class="submit-btn" value="로 그 인">
		</form>
			<Button class="submit-btn" onclick="location.href='sign_up' ">회 원 가 입</Button>
	</div>
</body>
</html>

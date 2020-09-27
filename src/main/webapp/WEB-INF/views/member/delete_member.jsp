<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE MEMBER</title>
<link rel="stylesheet" href="/board/css/member.css">
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
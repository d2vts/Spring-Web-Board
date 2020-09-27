<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="/board/css/home.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
				<a href="">MENU4</a>
			</nav>
		</div>
	</header>
	<main>
		<div class="container">
			<p>SPRING FRAMEWORK</p>
			<p>FORUM PROJECT</p>
		</div>
	</main>
	<script>
		$(window).on("load", function(){
			$("header, main").addClass("active");
		});
	</script>



<h1> Home </h1>

<c:if test="${userId == null}">
	<button onclick="location.href='login' ">로그인</button>
</c:if>
<c:if test="${userId != null}">
	<button onclick="location.href='mypage' ">마이페이지</button>
	<button onclick="location.href='logout' ">로그아웃</button>
</c:if>
<button onclick="location.href='sign_up' ">회원가입</button>
<button onclick="location.href='list' ">게시판</button>
</body>

</html>
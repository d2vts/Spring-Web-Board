<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>HOME</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
	<header>
		<div class="container">
			<h1><a id="h1-sp" href="/">Spring Project</a></h1>
			<nav>
				<a href="/list" id="white-a">게시판</a>
				<c:if test="${userId == null}">
					<a href="/login" id="white-a">로그인</a>
					<a href="/sign_up" id="white-a">회원가입</a>
				</c:if>
				<c:if test="${userId != null}">
					<a href="/logout" id="white-a">로그아웃</a>
					<a href="/mypage" id="white-a">마이페이지</a>
				</c:if>
				<a href="https://github.com/d2vts/Spring-Web-Board" id="white-a">GITHUB</a>
			</nav>
		</div>
	</header>
	<main>
		<div class="container">
			<p>SPRING FORUM PROJECT</p>
			<p>이태승 포트폴리오 입니다</p>
		</div>
	</main>
	<script>
		$(window).on("load", function(){
			$("header, main").addClass("active");
		});
	</script>


</body>

</html>
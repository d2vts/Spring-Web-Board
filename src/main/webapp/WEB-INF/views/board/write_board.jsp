<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
	crossorigin="anonymous" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="/board/css/w_u_board.css">
</head>

<body>
<header>
		<div class="container">
			<h1><a id="h1-sp" href="/board">Spring Project</a></h1>
			<nav>
				<a href="/board/list" id="white-a">게시판</a>
				<c:if test="${userId == null}">
					<a href="/board/login" id="white-a">로그인</a>
					<a href="/board/sign_up" id="white-a">회원가입</a>
				</c:if>
				<c:if test="${userId != null}">
					<a href="/board/logout" id="white-a">로그아웃</a>
					<a href="/board/mypage" id="white-a">마이페이지</a>
				</c:if>
				<a href="https://github.com/d2vts/Spring-Web-Board" id="white-a">GITHUB</a>
			</nav>
		</div>
	</header>
	<h1>게시글 작성</h1>
<div id="margin-top">
	<form action="write_board" method="POST" class="write-form">
		<div class="form-group">
		<p class="title-content">제목</p>
			<input type="text" name="boardTitle" class="form-control"
				id="exampleFormControlInput1" maxlength="30">
		<br>
		<p class="title-content">내용</p>
			<textarea class="form-control" name="boardContent" rows="10"  maxlength="1000"></textarea>
			<br><br>
			<input type="submit" class="btn btn-lg btn-block submit-btn" id="write-submit" value="글 작성">
		</div>
	</form>
	<button class="btn btn-lg btn-block submit-btn" id="write-submit"  onClick="location.href='/board/list'">목록으로</button>
	</div>
</body>
</html>
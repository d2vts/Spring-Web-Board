<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Home </h1>

<button><a href="mypage">마이페이지</a></button>
<c:if test="${userId == null}">
	<button><a href="login">로그인</a></button>
</c:if>
<c:if test="${userId != null}">
	<button><a href="logout">로그아웃</a></button>
</c:if>
<button><a href="sign_up">회원가입</a></button>
<button><a href="list">게시판</a></button>
</body>
</html>
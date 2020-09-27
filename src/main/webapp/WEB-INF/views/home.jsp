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
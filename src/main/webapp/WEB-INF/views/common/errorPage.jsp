<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Error Page</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet'
		type='text/css'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
		integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
		crossorigin="anonymous" />
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/error.css">
</head>

<body>

	<div class="header">
		<h1><b>E R R O R P A G E</b></h1>
	</div>

	<div class="container">
		<a href="/"><i class="fas fa-home fa-1g"></i> 홈으로 돌아가기</a>
		<br>
		<br>
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 400}">
			<h1><b>잘못 된 요청입니다.</b></h1>
		</c:if>
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 403}">
			<h1><b>요청이 거부되었습니다.</b></h1>
		</c:if>
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
			<h1><b>요청하신 페이지를 찾을 수 없습니다.</b></h1>
		</c:if>
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
			<h1><b>서버에 오류가 발생하여 요청을 수행할 수 없습니다.</b></h1>
		</c:if>
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 503}">
			<h1><b>서비스를 사용할 수 없습니다.</b></h1>
		</c:if>
	</div>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<link rel="stylesheet" href="/board/css/member.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/sign_up.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
		<h1>Modify</h1>
		<form:form commandName="memberVO">
			<div class="textbox">
				<i class="fas fa-user"></i>
				<input type="text" name="userId" id="userId" value="${memberVo.userId } " readonly>
				<p id="sign-check-info-id"></p>
				<form:errors path="userId" cssStyle="color:red;" />
			</div>
			<div class="textbox">
				<i class="fas fa-address-card"></i>
				<input type="text" name="userName" id="userName" value="${memberVo.userName }" readonly>
				<p id="sign-check-info-name"></p>
				<form:errors path="userName" cssStyle="color:red;" />
			</div>
			<div class="textbox">
				<i class="fas fa-id-badge"></i>
				<input type="text" name="userNickname" id="userNickname" value="${memberVo.userNickname }">
				<p id="sign-check-info-nick"></p>
				<form:errors path="userNickname" cssStyle="color:red;" />
			</div>
			<div class="textbox">
				<i class="fas fa-envelope"></i>
				<input type="email" name="userEmail" id="userEmail"	value="${memberVo.userEmail }">
				<p id="sign-check-info-email"></p>
				<form:errors path="userEmail" cssStyle="color:red;" />
			</div>
			<div class="textbox">
				<i class="fas fa-map-marker-alt"></i>
				<div class="select-div inline-block">
					<select id="userAddress" name="userAddress" class="custom-select custom-select-sm">
			        	<option class="select-option" value="서울특별시" <c:if test="${memberVo.userAddress == '서울특별시' }">selected</c:if>>서울특별시</option>
			        	<option class="select-option" value="대구광역시" <c:if test="${memberVo.userAddress == '대구광역시' }">selected</c:if>>대구광역시</option>
			        	<option class="select-option" value="부산광역시" <c:if test="${memberVo.userAddress == '부산광역시' }">selected</c:if>>부산광역시</option>
			      	</select>
				</div>
		   		<p id="sign-check-info-addr"></p>
		    </div>
		    <div>
		      	<i class="fas fa-venus-mars"></i>
		      	<input type="radio" name="userGender" id="userGender" value="남" <c:if test="${memberVo.userGender == '남' }">checked</c:if>>남
				<input type="radio" name="userGender" id="userGender" value="여" <c:if test="${memberVo.userGender == '여' }">checked</c:if>>여
				<p id="sign-check-info-gender"></p>
			</div>
			<input type="submit" class="submit-btn" value="전송">
		</form:form>
	</div>
</body>
</html>
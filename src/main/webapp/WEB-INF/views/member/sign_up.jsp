<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/sign_up.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/member.css">
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
	<div class="login-box">
		<h1>Sign Up</h1>
		<form:form commandName="memberVO"> <!-- 서버측에서도 에러처리를 했지만 일시적으로 주석처리 -->
	        <div class="textbox">
	        	<i class="fas fa-user"></i>
	        	<input type="text" name="userId" id="userId" placeholder="UserId" autocomplete="off" value="${memberVo.userId }"><br/>
				<p id="sign-check-info-id"></p>
				<%-- <form:errors path="userId" cssStyle="color:white; font-size:10px"/>	 --%>
	        </div>
			<div class="textbox">
				<i class="fas fa-lock"></i>
				<input type="password" name="userPassword" id="userPassword" placeholder="Password"><br/>
				<p id="sign-check-info-pw"></p>
				<%-- <form:errors path="userPassword" cssStyle="color:white; font-size:10px" /> --%>
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i>
	        	<input type="password" id="userPassword2" placeholder="Password_check"><br/>
				<p id="sign-check-info-pw2"></p>
			</div>
			<div class="textbox">
				<i class="fas fa-address-card"></i>
		        <input type="text" name="userName" id="userName" placeholder="UserName" value="${memberVo.userName }"><br>
				<p id="sign-check-info-name"></p>
				<%-- <form:errors path="userName" cssStyle="color:white; font-size:10px" /> --%>
			</div>
			<div class="textbox">
				<i class="fas fa-id-badge"></i>
		        <input type="text" name="userNickname" id="userNickname" placeholder="UserNickname" value="${memberVo.userNickname }"><br>
				<p id="sign-check-info-nick"></p>
				<%-- <form:errors path="userNickname" cssStyle="color:white; font-size:10px" /> --%>
			</div>
			<div class="textbox">
				<i class="fas fa-envelope"></i>
		        <input type="email" name="userEmail" id="userEmail" placeholder="UserEmail" value="${memberVo.userEmail }"><br>
				<p id="sign-check-info-email"></p>
				<%-- <form:errors path="userEmail" cssStyle="color:white; font-size:10px" /> --%>
			</div>
			<div class="textbox">
				<i class="fas fa-map-marker-alt"></i>
				<div class="select-div inline-block">
				    <select id="userAddress" name="userAddress" class="custom-select custom-select-sm">
			           <option class="select-option" value="서울특별시" selected>서울특별시</option>
			           <option class="select-option" value="부산광역시">부산광역시</option>
			           <option class="select-option" value="울산광역시">울산광역시</option>
			           <option class="select-option" value="대구광역시">대구광역시</option>
			           <option class="select-option" value="대전광역시">대전광역시</option>
			           <option class="select-option" value="인천광역시">인천광역시</option>
			           <option class="select-option" value="광주광역시">광주광역시</option>
			           <option class="select-option" value="세종특별시">세종특별시</option>
			           <option class="select-option" value="경기도">경기도</option>
			           <option class="select-option" value="경상남도">경상남도</option>
			           <option class="select-option" value="경상북도">경상북도</option>
			           <option class="select-option" value="전라남도">전라남도</option>
			           <option class="select-option" value="전라북도">전라북도</option>
			           <option class="select-option" value="충청남도">충청남도</option>
			           <option class="select-option" value="충청북도">충청북도</option>
			           <option class="select-option" value="강원도">강원도</option>
			           <option class="select-option" value="제주도">제주도</option>
				    </select>
			    </div>
		   		<p id="sign-check-info-addr"></p>
		    </div>
			<div>
				<i class="fas fa-venus-mars"></i>
		        <input type="radio" name="userGender" id="userGender" value="남" checked>남&nbsp;&nbsp;&nbsp;
			    <input type="radio" name="userGender" id="userGender" value="여">여
				<p id="sign-check-info-gender"></p>
			</div>
		  <input type="submit" class="submit-btn" value="전송">
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/member.css">
<script src="/js/modify_member.js"></script>
</head>
<body>
	<header>
		<div class="container">
			<h1>
				<a id="h1-sp" href="/">Spring Project</a>
			</h1>
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
		<h1>Modify</h1>
		<form:form commandName="memberVO">
			<div class="textbox">
				<i class="fas fa-user"></i> <input type="text" name="userId"
					id="userId" value="${memberVo.userId } " readonly>
				<p id="sign-check-info-id"></p>
			</div>
			<div class="textbox">
				<i class="fas fa-address-card"></i> <input type="text"
					name="userName" id="userName" value="${memberVo.userName }"
					readonly>
			</div>
			<div class="textbox">
				<i class="fas fa-id-badge"></i> <input type="text"
					name="userNickname" id="userNickname"
					value="${memberVo.userNickname}"><br />
				<p id="sign-check-info-nick"></p>
				<form:errors path="userNickname"
					cssStyle="color:blue; font-size:10px" />
			</div>
			<div class="textbox">
				<i class="fas fa-envelope"></i> <input type="email" name="userEmail"
					id="userEmail" value="${memberVo.userEmail }"><br />
				<p id="sign-check-info-email"></p>
				<form:errors path="userEmail" cssStyle="color:blue; font-size:10px" />
			</div>
			<div class="textbox">
				<i class="fas fa-map-marker-alt"></i>
				<div class="select-div inline-block">
					<select id="userAddress" name="userAddress"
						class="custom-select custom-select-sm">
						<option class="select-option" value="서울특별시"
							<c:if test="${memberVo.userAddress == '서울특별시' }">selected</c:if>>서울특별시</option>
						<option class="select-option" value="부산광역시"
							<c:if test="${memberVo.userAddress == '부산광역시' }">selected</c:if>>부산광역시</option>
						<option class="select-option" value="울산광역시"
							<c:if test="${memberVo.userAddress == '울산광역시' }">selected</c:if>>울산광역시</option>
						<option class="select-option" value="대구광역시"
							<c:if test="${memberVo.userAddress == '대구광역시' }">selected</c:if>>대구광역시</option>
						<option class="select-option" value="대전광역시"
							<c:if test="${memberVo.userAddress == '대전광역시' }">selected</c:if>>대전광역시</option>
						<option class="select-option" value="인천광역시"
							<c:if test="${memberVo.userAddress == '인천광역시' }">selected</c:if>>인천광역시</option>
						<option class="select-option" value="광주광역시"
							<c:if test="${memberVo.userAddress == '광주광역시' }">selected</c:if>>광주광역시</option>
						<option class="select-option" value="세종특별시"
							<c:if test="${memberVo.userAddress == '세종특별시' }">selected</c:if>>세종특별시</option>
						<option class="select-option" value="경기도"
							<c:if test="${memberVo.userAddress == '경기도' }">selected</c:if>>경기도</option>
						<option class="select-option" value="경상남도"
							<c:if test="${memberVo.userAddress == '경상남도' }">selected</c:if>>경상남도</option>
						<option class="select-option" value="경상북도"
							<c:if test="${memberVo.userAddress == '경상북도' }">selected</c:if>>경상북도</option>
						<option class="select-option" value="전라남도"
							<c:if test="${memberVo.userAddress == '전라남도' }">selected</c:if>>전라남도</option>
						<option class="select-option" value="전라북도"
							<c:if test="${memberVo.userAddress == '전라북도' }">selected</c:if>>전라북도</option>
						<option class="select-option" value="충청남도"
							<c:if test="${memberVo.userAddress == '충청남도' }">selected</c:if>>충청남도</option>
						<option class="select-option" value="충청북도"
							<c:if test="${memberVo.userAddress == '충청북도' }">selected</c:if>>충청북도</option>
						<option class="select-option" value="강원도"
							<c:if test="${memberVo.userAddress == '강원도' }">selected</c:if>>강원도</option>
						<option class="select-option" value="제주도"
							<c:if test="${memberVo.userAddress == '제주도' }">selected</c:if>>제주도</option>

					</select>
				</div>
				<p id="sign-check-info-addr"></p>
			</div>
			<input type="submit" class="submit-btn" value="전송">
		</form:form>
		<br />
		<br />
		<p style="color: white">모든칸 확인해주세요</p>
	</div>
</body>
</html>
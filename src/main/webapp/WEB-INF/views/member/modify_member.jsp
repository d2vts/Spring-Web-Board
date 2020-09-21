<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<form action="modify_member" method="POST">
		아이디 : <input type="text" name="userId" value="${member.userId }" readonly> <br/>
		이름 : <input type="text" name="userName" value="${member.userName }" readonly><br/>
		닉네임 : <input type="text" name="userNickname" value="${member.userNickname }"><br/>
		이메일 : <input type="text" name="userEmail" value="${member.userEmail }"><br/>
		주소 : <input type="text" name="userAddress" value="${member.userAddress }"><br/>
		성별 : <input type="text" name="userGender" value="${member.userGender }" readonly><br/>
		<input type="submit" value="전송">
	</form>
</body>
</html>
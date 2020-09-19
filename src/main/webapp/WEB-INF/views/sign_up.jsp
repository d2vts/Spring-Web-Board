<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원가입 </h1>



<form action="sign_up" method="POST">


아이디 : <input type="text" name="userId"> <br/>
비밀번호 : <input type="text" name="userPassword"><br/>
이름 : <input type="text" name="userName"><br/>
닉네임 : <input type="text" name="userNickname"><br/>
이메일 : <input type="text" name="userEmail"><br/>
주소 : <input type="text" name="userAddress"><br/>
성별 : <input type="text" name="userGender"><br/>

<input type="submit" value="전송">




</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정</h1>

	<form action="modify_board" method="post">
	    <table>
    		<tr>
	            <td><input type="text"> 제목자리</td>
	        </tr>
	        <tr>
	            <td><input type="text"> 게시글자리</td>
	        </tr>
	        <tr>
	            <td><input type="submit" value="수정"> <button><a href="">취소</a></button></td>
	        </tr>
	    </table>
    </form>
</body>
</html>
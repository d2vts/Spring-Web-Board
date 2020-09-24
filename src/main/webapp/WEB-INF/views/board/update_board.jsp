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

	<form action="update_board" method="post">
	    <table>
	    	<input type="hidden" name="idNum" value="${board.idNum }">
    		<tr>
	            <td>제목 : <input type="text" name="boardTitle" value="${board.boardTitle }"></td>
	        </tr>
	        <tr>
	            <td>내용 : <input type="text" name="boardContent" value="${board.boardContent }"></td>
	        </tr>
	        <tr>
	            <td><input type="submit" value="수정"> <button><a href="">취소</a></button></td>
	        </tr>
	    </table>
    </form>
</body>
</html>
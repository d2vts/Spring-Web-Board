<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>게시글 작성</h1>
    <form action="write_board" method="POST">
                  제목 : <input type="text" name="boardTitle"><br/><br/>
                  내용 : <input type="text" name="boardContent"><br/><br/>
        <input type="submit" value="글작성">
    </form>
</body>
</html>
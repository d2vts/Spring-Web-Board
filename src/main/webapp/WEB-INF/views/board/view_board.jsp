<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 게시글 보기 </h1>
	
	<table>
	<tr>
	<th>제목</th>
	<th>${board.boardTitle}</th>
	</tr>
	<tr>
	<td>작성자</td>
	<td>${board.userNickname}(${board.userId})</td>
	</tr>
	<tr>
	<td>내용</td>
	<td>${board.boardContent}</td>
	</tr>
	<tr>
	<td colspan="2"><a href="/board/list/modify_board?boardNum=${board.idNum}">수정하기</a><a href="/board/list/delete_board?boardNum=${board.idNum}">삭제하기</a> 목록으로</td>
	</tr>	
	</table>
	
</body>
</html>
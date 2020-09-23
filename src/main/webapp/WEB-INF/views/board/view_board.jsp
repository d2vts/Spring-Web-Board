<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.modify-reply{display:none}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
//var $jstatus = $('#status').val();
//console.log($jstatus);
function modify(aa){
	alert(aa);
	
	$('#'+aa).css("display","block");
}
//수정버튼을 누르게되면 textarea css를 건드려서 height를 늘려줌 
</script>

</head>
<body>

	<h1>게시글 보기</h1>

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
			<td colspan="2">
        <a href="/board/list/modify_board?boardNum=${board.idNum}">수정하기</a><a href="/board/list/delete_board?boardNum=${board.idNum}">삭제하기</a>
				<a href="/board/list">목록으로</a></td>
		</tr>
	
	</table>
	
	<form action="view/write_reply" method="POST">
	<input type="hidden" name ="boardNum" value="${board.idNum}">
	<table>
	<tr>
	<td><input type="text" name="re_content"></td>
	<td><input type="submit" value="등록"></td>
	</tr>
	</table>

	<form action="view/write_reply" method="POST">
		<input type="hidden" name="boardNum" value="${board.idNum}">
		<table>
			<tr>
				<td><input type="text" name="re_content"></td>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>

	<table>
		<c:forEach items="${replyInfo}" var="reply" varStatus="status">
			<tr>
				<td>${reply.re_userNickname }(${reply.re_userId })&nbsp;&nbsp;</td>
				<td>${reply.re_content}</td>
			</tr>
			<c:if test="${reply.re_userNickname.equals(userNickname)}">
			<tr>
				<td colspan="2">
				<form class="modify-reply" id="${reply.re_idNum}" action="/board/list/write_reply" method="post">
				<input type="hidden" name ="re_idNum" value="${reply.re_idNum}">
				<input type="hidden" name ="re_boardId" value="${board.idNum}">
				<textarea name="re_content">${reply.re_content}</textarea>
				<input type="submit" value="수정확인">
				</form><br/>
				<button id="modify_btn" onclick="modify(${reply.re_idNum})">수정하기</button>
				<button><a href="/board/list/delete_reply?replyNum=${reply.re_idNum}&boardNum=${board.idNum}">삭제하기</a></button>
				</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>
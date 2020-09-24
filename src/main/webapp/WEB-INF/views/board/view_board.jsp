<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle}</title>
<style type="text/css">
.update-reply{display:none}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function update(aa){	$('#'+aa).css("display","block");}
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
        <a href="/board/list/update_board?boardNum=${board.idNum}">수정하기</a><a href="/board/list/delete_board?boardNum=${board.idNum}">삭제하기</a>
				<a href="/board/list">목록으로</a></td>
		</tr>
	
	</table>

	<form action="view/write_reply" method="POST">
		<input type="hidden" name="re_boardId" value="${board.idNum}">
		<table>
			<tr>
				<td><textarea name="re_content"></textarea></td>
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
				<form class="update-reply" id="${reply.re_idNum}" action="/board/list/update_reply" method="post">
				<input type="hidden" name ="re_idNum" value="${reply.re_idNum}">
				<input type="hidden" name ="re_boardId" value="${board.idNum}">
				<textarea name="re_content">${reply.re_content}</textarea>
				<input type="submit" value="수정확인">
				</form><br/>
				<button id="update_btn" onclick="update(${reply.re_idNum})">수정하기</button>
				<button><a href="/board/list/delete_reply?replyNum=${reply.re_idNum}&boardNum=${board.idNum}">삭제하기</a></button>
				</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>
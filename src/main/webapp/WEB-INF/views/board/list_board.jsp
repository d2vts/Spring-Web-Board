<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>게시판 리스트</h1>

	<table>
		<tr>
			<th>No.</th>
			<th width="500" style="text-align:center" >제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		<c:forEach items="${boardInfo}" var="list">
		<tr>
			<td>${list.idNum}</td>
			<td width="500" style="text-align:center" ><a href="/board/list/view?boardNum=${list.idNum}">${list. boardTitle}</a></td>
			<td>${list. userNickname}</td>
			<td>${list. boardView}</td>
			<td>${list. cDate}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<button>
					<a href="list/write_board">글작성</a>
				</button>
			</td>
		</tr>
	</table>

</body>
</html>
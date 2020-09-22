<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.') }" />
	<div>
		<form>
			<fieldset>
				<select name="field">
					<option ${(param.field == "boardTitle")?"selected":"" } value="boardTitle">제목</option>
					<option ${(param.field == "userNickname")?"selected":"" } value="userNickname">작성자</option>
					<option ${(param.field == "titleNick")?"selected":"" } value="titleNick">제목+작성자</option>
				</select> 
				<input type="text" name="query" value="${param.query}"/>
				<input type="submit" value="검색" />
			</fieldset>
		</form>
	</div>
	
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
			<td>
				<c:if test="${startNum > 1}">
					<a href="?page=${startNum-1}&field=${param.field}&query=${param.query}">이전</a>
				</c:if>
				<c:if test="${startNum <= 1}">
					<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>	
			</td>
			<td>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i) <= lastNum}">
						<a href="?page=${startNum+i}&field=${param.field}&query=${param.query}" >${startNum+i}</a>
					</c:if>
				</c:forEach>
			</td>
			<td>
				<c:if test="${startNum+4 < lastNum}">
					<a href="?page=${startNum+5}&field=${param.field}&query=${param.query}">다음</a>
				</c:if>
				<c:if test="${startNum+4 >= lastNum }">	
					<span onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
			</td>
		</tr>
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
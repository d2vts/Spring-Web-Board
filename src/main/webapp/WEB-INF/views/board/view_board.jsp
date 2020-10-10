<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle}</title>
<style type="text/css">
.update-reply {
	display: none
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
	crossorigin="anonymous" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<script type="text/javascript">
function update(mod_reply){
	$('#update_btn').css("color", "gray");
	$('#undo_btn').css("color", "#4caf50");
	$('#'+mod_reply).css("display","block");
	}
	
function undo(mod_reply){
	$('#update_btn').css("color", "#4caf50");
	$('#undo_btn').css("color", "gray");
	$('#'+mod_reply).css("display","none");
	}
</script>
<link rel="stylesheet" href="/board/css/view.css">
</head>
<body>
<header>
		<div class="container">
			<h1><a id="h1-sp" href="/board">Spring Project</a></h1>
			<nav>
				<a href="/board/list" id="white-a">게시판</a>
				<c:if test="${userId == null}">
					<a href="/board/login" id="white-a">로그인</a>
					<a href="/board/sign_up" id="white-a">회원가입</a>
				</c:if>
				<c:if test="${userId != null}">
					<a href="/board/logout" id="white-a">로그아웃</a>
					<a href="/board/mypage" id="white-a">마이페이지</a>
				</c:if>
				<a href="https://github.com/d2vts/Spring-Web-Board" id="white-a">GITHUB</a>
			</nav>
		</div>
	</header>
	<div><br><br><br><br></div>
	<table class="table" id="view-table">
		<thead>
			<tr>
				<td></td>
				<td class="write-update-list table-view-second">
				<c:if test="${board.userNickname.equals(userNickname)}">
				<a href="/board/list/update_board?boardNum=${board.idNum}">
				<i style="" class="fas fa-pen fa-2x"></i>&nbsp;&nbsp;수정</a> 
				<a href="/board/list/delete_board?boardNum=${board.idNum}">
				<i class="fas fa-trash-alt fa-2x"></i>삭제</a>
				</c:if>
				&nbsp;&nbsp;&nbsp;
				<a href="/board/list"><i class="fas fa-undo-alt fa-2x"></i>&nbsp;&nbsp;목록으로</a>&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th class="table-left" scope="col">&nbsp;&nbsp;<i
					class="fas fa-clipboard fa-3x"></i></th>
				<th scope="col" class="table-view-second" id="view-title">${board.boardTitle}</th>
			</tr>

			<tr>
				<th class="table-left" scope="row">&nbsp;&nbsp;<i
					class="fas fa-user fa-3x"></i></th>
				<td class="table-view-second"><span id="table-writer-nickname">${board.userNickname}</span>
					(<span id="table-writer-id"> ${board.userId} </span>)</td>

			</tr>
			<tr class="content-tr">
				<th class="table-left" scope="row">&nbsp;&nbsp;<i
					class="fas fa-file-alt fa-3x"></i></th>
				<td class="table-view-second" id="content-enter">${board.boardContent}</td>

			</tr>
		</tbody>
	</table>


	<!-- --------------------------------------------------------------------------------------------- -->


	<div class="form-group" id="write-reply-group">
		<form action="view/write_reply" method="POST">
			<input type="hidden" name="re_boardId" value="${board.idNum}">
			<textarea class="form-control" id="exampleFormControlTextarea1"
				name="re_content" rows="3" placeholder="댓글 입력란"></textarea>
			<input type="submit" class="btn btn-lg btn-block submit-btn"
				id="reg-reply" value="댓글등록">
		</form>
	</div>
	<!-- --------------------------------------------------------------------------------------------- -->

	<table class="table" id="view-table">
		<c:forEach items="${replyInfo}" var="reply" varStatus="status">
			<tr>
				<td><i class="fas fa-user-tie fa-2x"></i>
					${reply.re_userNickname }(${reply.re_userId })&nbsp;&nbsp;</td>
				<td><div id="content-enter">${reply.re_content}</div></td>
				<td id="third-td"><button class="reply-modi-update" id="update_btn"
						onclick="update(${reply.re_idNum})">
						<i class="fas fa-pen fa-2x"></i>
					</button>
					<button class="reply-undo" id="undo_btn"onclick="undo(${reply.re_idNum})">
						<i class="fas fa-eject fa-2x"></i>
					</button>
					<button class="reply-modi-update">
						<a id="reply-delete-a"
							href="/board/list/delete_reply?replyNum=${reply.re_idNum}&boardNum=${board.idNum}">
							<i class="fas fa-trash-alt fa-2x"></i>
						</a>
					</button></td>
			</tr>
			<c:if test="${reply.re_userNickname.equals(userNickname)}">
				<tr>
					<td colspan="3">
						<form class="update-reply" id="${reply.re_idNum}"
							action="/board/list/update_reply" method="post">
							<input type="hidden" name="re_idNum" value="${reply.re_idNum}">
							<input type="hidden" name="re_boardId" value="${board.idNum}">
							<textarea class="form-control" name="re_content"
								name="re_content" rows="2" maxlength="200">${reply.re_content}</textarea>
							<input type="submit" class="btn btn-lg btn-block submit-btn"
								id="reg-reply" value="수정확인">
						</form> <br />
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>



</body>
</html>
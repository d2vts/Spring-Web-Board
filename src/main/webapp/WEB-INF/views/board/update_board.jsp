<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardTitle}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="/board/css/w_u_board.css">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>&nbsp;</h1>
    
    <form action="update_board" method="POST" class="write-form">
    <input type="hidden" name="idNum" value="${board.idNum }">
		<div class="form-group">
		<p class="title-content">제목</p>
			<input type="text" name="boardTitle" class="form-control" maxlength="50"
				id="exampleFormControlInput1" value="${board.boardTitle }">
		<br>
		<p class="title-content">내용</p>
			<textarea class="form-control" name="boardContent" rows="10" maxlength="2000">${board.boardContent }</textarea>
			<br><br>
			<input type="submit" class="btn btn-lg btn-block submit-btn" id="write-submit" value="수정 완료">
		</div>
	</form>
	<button class="btn btn-lg btn-block submit-btn" id="write-submit"  onClick="location.href='/board/list'">목록으로</button>
</body>
</body>
</html>
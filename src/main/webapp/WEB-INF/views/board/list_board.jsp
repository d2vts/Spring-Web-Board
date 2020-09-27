<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/list.css">
<link rel="stylesheet" href="css/member.css">
</head>
<body>
	<div id="h1-div" class="login-box"><h1>자유 게시판</h1></div>
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.') }" />
	<div class="col-md-10 col-md-offset-1" id="list-table">

            <div id="list-table" class="panel panel-default panel-table">
              <div class="panel-heading" id="list-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <form>
						<fieldset>
							<select name="field" class="noboot-custom-select">
								<option ${(param.field == "boardTitle")?"selected":"" } value="boardTitle" id="select-option">제목</option>
								<option ${(param.field == "userNickname")?"selected":"" } value="userNickname" id="select-option">작성자</option>
								<option ${(param.field == "titleNick")?"selected":"" } value="titleNick" id="select-option">제목+작성자</option>
							</select> 
							<input type="text" name="query" value="${param.query}" maxlength="10" class="noboot-search-input" placeholder="&nbsp;&nbsp;검색"/>
							<!-- <input type="submit" value="검색" /> -->
							<button class="btn btn-sm btn-success btn-create" id="search-btn">검색</button>
						</fieldset>
					</form>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <button type="button" style="height: 30px;"class="btn btn-sm btn-success btn-create" onclick="location.href='list/write_board'">게시글 작성</button>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-bordered table-list">
                  <thead>
                    <tr>
                        <th style="min-width:50px;">번호</th>
                        <th>제목</th>
                        <th>작성자</th>
						<th style="min-width:60px;">조회수</th>
						<th>작성일자</th>
                    </tr> 
                  </thead>
                  <tbody>
					<c:forEach items="${boardInfo}" var="list">
						<tr id="list-tr">
							<td id="first-td">${list.idNum}</td>
							<td width="1000" style="text-align:left" onClick="location.href='/board/list/view?boardNum=${list.idNum}'">&nbsp;&nbsp;&nbsp;
							<a id ="board-title-td" href="/board/list/view?boardNum=${list.idNum}">${list. boardTitle}</a></td>
							<td>${list. userNickname}</td>
							<td>${list. boardView}</td>
							<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list. CDate}"/></td>
						</tr>
						</c:forEach>
                        </tbody>
				</table>
				

				<!-- 아래에는 페이징 처리 -->
              </div>
              <div class="panel-footer">
                <div class="row">
                  <div class="col col-xs-4">Page ${page} of ${fn:substringBefore(Math.ceil(count/10), '.') }
                  </div>
                  <div class="col col-xs-8" id="paging-div">
                    <ul class="pagination hidden-xs pull-right" id="paging-ul">
                      <li id="paging-li"><c:if test="${startNum > 1}">
						<a id="pagination-green-font" href="?page=${startNum-1}&field=${param.field}&query=${param.query}">이전</a>
					</c:if>
					<c:if test="${startNum <= 1}">
						<span id="pagination-green-font" onclick="alert('이전 페이지가 없습니다.');">이전</span>
					</c:if>	</li>
                      <li id="paging-li"><c:forEach var="i" begin="0" end="4">
						<c:if test="${(startNum+i) <= lastNum}">
							<a id="pagination-green-font" href="?page=${startNum+i}&field=${param.field}&query=${param.query}" >${startNum+i}</a>
						</c:if>
					</c:forEach></li>
                      <li id="paging-li"><c:if test="${startNum+4 < lastNum}">
						<a id="pagination-green-font" href="?page=${startNum+5}&field=${param.field}&query=${param.query}">다음</a>
					</c:if>
					<c:if test="${startNum+4 >= lastNum }">	
						<span id="pagination-green-font" onclick="alert('다음 페이지가 없습니다.');">다음</span>
					</c:if></li>
                      <!-- <li><a href="#">*</a></li> -->
                    </ul>
                    <ul class="pagination visible-xs pull-right">
                        <li><a href="#">«</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>

</body>
</html>
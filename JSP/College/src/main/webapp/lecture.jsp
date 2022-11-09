<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.ac.college.bean.LecBean"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.college.dao.CollegeDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CollegeDAO dao = CollegeDAO.getInstance();
	//강좌목록 가져오기
	List<LecBean> lectures = dao.selectLectures();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College::Lecture</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="/College/js/lecTable.js"></script>
		<script>
			$(function(){
				//강좌등록 테이블 생성
				$(document).on('click', '.btnCreateLecTable', function(e){
					e.preventDefault();
					createLecTable();
				});
				//강좌등록 테이블 제거
				$(document).on('click', '.btnCloseLecTable', function(e){
					e.preventDefault();
					closeLecTable();
				});
				//강좌 등록
				$(document).on('click', 'input[type=submit]', function(e){
					e.preventDefault();
					registerLecTable();
					
					//json 생성
					let input = new Object();
					input.lecNo = $('input[name=lecNo]').val();
					input.lecName = $('input[name=lecName]').val();
					input.lecCredit = $('input[name=lecCredit]').val();
					input.lecTime = $('input[name=lecTime]').val();
					input.lecClass = $('input[name=lecClass]').val();
					let addedLec = JSON.stringify(input);
					
					createLecTable();
					lecAdd(addedLec);
					
				});
				
				//test
				$(document).on('click', 'input[type=submit]', function(e){
					e.preventDefault();
					
					
					
					
				});
			});
		</script>
	</head>
	<body>
		<h3>강좌관리</h3>
		<%@ include file="./_headerLink.jsp" %>
		
		<div class="lecList">
			<h4>강좌현황</h4>
			<button type="button" class="btnCreateLecTable">등록</button>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>강좌명</th>
					<th>학점</th>
					<th>시간</th>
					<th>강의장</th>
				</tr>
				<% for(LecBean lecture : lectures) {%>
				<tr>
					<td><%= lecture.getLecNo() %></td>
					<td><%= lecture.getLecName() %></td>
					<td><%= lecture.getLecCredit() %></td>
					<td><%= lecture.getLecTime() %></td>
					<td><%= lecture.getLecClass() %></td>
				</tr>
				<% } %>
			</table>
		</div>
		<div class="lecTable"></div>
	</body>
</html>
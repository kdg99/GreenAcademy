<%@page import="java.util.List"%>
<%@page import="kr.ac.college.dao.CollegeDAO"%>
<%@page import="kr.ac.college.bean.StdBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CollegeDAO dao = CollegeDAO.getInstance();
	//학생목록 가져오기
	List<StdBean> students = dao.selectStudents();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College::Student</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="/College/js/stdTable.js"></script>
		<script>
			$(function(){
				//강좌등록 테이블 생성
				$(document).on('click', '.btnCreateStdTable', function(e){
					e.preventDefault();
					createStdTable();
				});
				//강좌등록 테이블 제거
				$(document).on('click', '.btnCloseStdTable', function(e){
					e.preventDefault();
					closeStdTable();
				});
				//강좌 등록
				$(document).on('click', 'input[type=submit]', function(e){
					e.preventDefault();
					registerStdTable();
					
					//json 생성
					let input = new Object();
					input.stdNo = $('input[name=stdNo]').val();
					input.stdName = $('input[name=stdName]').val();
					input.stdHp = $('input[name=stdHp]').val();
					input.stdYear = $('input[name=stdYear]').val();
					input.stdAddress = $('input[name=stdAddress]').val();
					let addedStd = JSON.stringify(input);
					
					createStdTable();
					stdAdd(addedStd);
				});
			});
		</script>
	</head>
	<body>
		<h3>학생관리</h3>
		<%@ include file="./_headerLink.jsp" %>
		
		<div class="stdList">
			<h4>학생목록</h4>
			<button type="button" class="btnCreateStdTable">등록</button>
			<table border="1">
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>휴대폰</th>
					<th>학년</th>
					<th>주소</th>
				</tr>
				<% for(StdBean student : students) {%>
				<tr>
					<td><%= student.getStdNo() %></td>
					<td><%= student.getStdName() %></td>
					<td><%= student.getStdHp() %></td>
					<td><%= student.getStdYear() %></td>
					<td><%= student.getStdAddress() %></td>
				</tr>
				<% } %>
			</table>
		</div>
		<div class="stdTable"></div>
	</body>
</html>
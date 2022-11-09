<%@page import="kr.ac.college.bean.RegBean"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.college.dao.CollegeDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CollegeDAO dao = CollegeDAO.getInstance();
	//수강목록 가져오기
	List<RegBean> registers = dao.selectRegisters();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College::Register</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="/College/js/regTable.js"></script>
		<script>
			$(function(){
				//수강등록 테이블 생성
				$(document).on('click', '.btnCreateRegTable', function(e){
					e.preventDefault();
					createRegTable();
				});
				//수강등록 테이블 제거
				$(document).on('click', '.btnCloseRegTable', function(e){
					e.preventDefault();
					closeRegTable();
				});
				
				//.----------tnwjd
				
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
		<h3>수강관리</h3>
		<%@ include file="./_headerLink.jsp" %>
		
		<div class="regList">
			<h4>수강현황</h4>
			<input type="text" class="searchStdNo" />
			<button type="button" class="btnSearchStdNo">검색</button>
			<button type="button" class="btnCreateRegTable">수강신청</button>
			<table border="1">
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>강좌명</th>
					<th>강좌코드</th>
					<th>중간시험</th>
					<th>기말시험</th>
					<th>총점시험</th>
					<th>등급시험</th>
				</tr>
				<% for(RegBean register : registers) {%>
				<tr>
					<td><%= register.getRegStdNo() %></td>
					<td><%= register.getRegStdName() %></td>
					<td><%= register.getRegLecName() %></td>
					<td><%= register.getRegLecNo() %></td>
					<td><%= register.getRegMidScore() %></td>
					<td><%= register.getRegFinalScore() %></td>
					<td><%= register.getRegTotalScore() %></td>
					<td><%= register.getRegGrade() %></td>
				</tr>
				<% } %>
			</table>
		</div>
		<div class="regTable">
		
		</div>
		
	</body>
</html>
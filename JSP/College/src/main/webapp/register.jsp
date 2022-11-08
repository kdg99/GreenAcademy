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
	</head>
	<body>
		<h3>수강관리</h3>
		<%@ include file="./_headerLink.jsp" %>
		
		<div class="regList">
			<h4>수강현황</h4>
			<button type="button" class="btnCreateRegTable">등록</button>
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
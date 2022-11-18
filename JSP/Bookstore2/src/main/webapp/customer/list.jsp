<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BookStore::CustomerList</title>
	</head>
	<body>
		<h3>고객목록</h3>
		<a href="/Bookstore2/index.jsp">처음으로</a>
		<a href="/Bookstore2/customer/register.do">고객등록</a>

		<table border="1" class="customerList">
			<tr>
				<th>고객번호</th>
				<th>고객명</th>
				<th>주소</th>
				<th>휴대폰</th>
				<th>관리</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
			<tr>
				<td>${ customer.getCustId() }</td>
				<td>${ customer.getCustName() }</td>
				<td>${ customer.getCustAddr() }</td>
				<td>${ customer.getCustHp() }</td>
				<td>
					<a href="/Bookstore2/customer/modify.do?custId=${customer.getCustId()}">수정</a>
					<a href="/Bookstore2/customer/delete.do?custId=${customer.getCustId()}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>		
	</body>
</html>
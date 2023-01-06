<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer::List</title>
	</head>
	<body>
		<h3>고객목록</h3>
		<a href="/BookStore/">처음으로</a>
		<a href="/BookStore/customer/register">고객등록</a>
		
		<table border="1">
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>주소</th>
			<th>휴대폰</th>
			<th>관리</th>
		</tr>
		<c:forEach var="cust" items="${ custs }">
		<tr>
			<td>${ cust.custId }</td>
			<td>${ cust.custName }</td>
			<td>${ cust.custAddr }</td>
			<td>${ cust.custHp }</td>
			<td>
				<label><a href="/BookStore/customer/modify?id=${ cust.custId }">수정</a></label>
				<label><a href="/BookStore/customer/delete?id=${ cust.custId }">삭제</a></label>
			</td>
		</tr>
		</c:forEach>
		</table>
	</body>
</html>
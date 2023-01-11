<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::list</title>
	</head>
	<body>
		<h3>user4 목록</h3>
		<a href="/Ch05/">user4 메인</a>
		<a href="/Ch05/user4/register">user4 등록</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var="user" items="${ users }">
			<tr>
				<td>${ user.uid }</td>
				<td>${ user.name }</td>
				<td>${ user.gender }</td>
				<td>${ user.age }</td>
				<td>${ user.addr }</td>
				<td>
					<a href="/Ch05/user4/modify?uid=${ user.uid }">수정</a>
					<a href="/Ch05/user4/delete?uid=${ user.uid }">삭제</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		
	</body>
</html>
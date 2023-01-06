<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer::modify</title>
	</head>
	<body>
		<h3>고객수정</h3>
		<a href="/BookStore/">처음으로</a>
		<a href="/BookStore/customer/list">고객목록</a>
		<form action="/BookStore/customer/modify" method="POST">
			<table border="1">
			<tr>
				<td>고객번호</td>
				<td><input type="text" name="custId" value="${ cust.custId }" readonly /></td>
			</tr>
			<tr>
				<td>고객명</td>
				<td><input type="text" name="custName" value="${ cust.custName }" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="custAddr" value="${ cust.custAddr }" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="custHp" value="${ cust.custHp }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정" /></td>
			</tr>
			</table>
		</form>		
	</body>
</html>
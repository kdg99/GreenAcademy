<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>student::modify</title>
	</head>
	<body>
		<h3>student 수정하기</h3>
		
		<a href="/Ch09/user1//list.jsp">student 목록</a>
		
		<form action="/Ch09/user1/modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td> <input type="text" name="stdNo" readonly value=""/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="stdName" value=""/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td> <input type="text" name="stdHp" value=""/></td>
				</tr>
				<tr>
					<td>학년</td>
					<td><input type="number" name="stdYear" value=""/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td> <input type="text" name="stdAddress" value=""/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>
			</table>
		</form>
		
		
	</body>
</html>
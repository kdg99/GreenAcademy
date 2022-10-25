<%@page import="java.util.ArrayList"%>
<%@page import="bean.User5Bean"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("uid");
	
	User5Bean ub = null;
	try{
		Connection conn = DB.getInstance().getDBCP();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `user5` WHERE `uid`='"+uid+"'");
		
		while(rs.next()){
			ub = new User5Bean();
			
			ub.setUid(rs.getString(1));
			ub.setName(rs.getString(2));
			ub.setBirth(rs.getString(3));
			ub.setAge(rs.getInt(4));
			ub.setAddr(rs.getString(5));
			ub.setHp(rs.getString(6));
			
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::modify</title>
	</head>
	<body>
		<h3>user5 수정하기</h3>
		
		<a href="./list.jsp">user5 목록</a>
		
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="uid" readonly value="<%=ub.getUid() %>"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="name" value="<%=ub.getName() %>"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td> <input type="text" name="birth" value="<%=ub.getBirth() %>"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td> <input type="text" name="age" value="<%=ub.getAge() %>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td> <input type="text" name="addr" value="<%=ub.getAddr() %>"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td> <input type="text" name="hp" value="<%=ub.getHp() %>"/></td>
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
<%@page import="bean.StudentBean"%>
<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String stdNo = request.getParameter("stdNo");
	
	StudentBean sb = null;
	try{
		Connection conn = DB.getInstance().getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `student` WHERE `stdNo`='"+stdNo+"'");

		if(rs.next()){
			sb = new StudentBean();
			sb.setStdNo(rs.getString(1));
			sb.setStdName(rs.getString(2));
			sb.setStdHp(rs.getString(3));
			sb.setStdYear(rs.getInt(4));
			sb.setStdAddress(rs.getString(5));
		}
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>student::modify</title>
	</head>
	<body>
		<h3>student 수정하기</h3>
		
		<a href="./list.jsp">student 목록</a>
		
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td> <input type="text" name="stdNo" readonly value="<%=sb.getStdNo() %>"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="stdName" value="<%=sb.getStdName() %>"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td> <input type="text" name="stdHp" value="<%=sb.getStdHp() %>"/></td>
				</tr>
				<tr>
					<td>학년</td>
					<td><input type="number" name="stdYear" value="<%= sb.getStdYear() %>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td> <input type="text" name="stdAddress" value="<%=sb.getStdAddress() %>"/></td>
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
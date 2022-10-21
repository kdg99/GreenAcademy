<%@page import="bean.CustBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int custId = Integer.parseInt(request.getParameter("custId"));
	
	CustBean cb = null;
	try{
		Connection conn = DB.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `customer` WHERE `custId`='"+custId+"'");
		
		while(rs.next()){
			cb = new CustBean();
			
			cb.setCustId(rs.getInt(1));
			cb.setCustName(rs.getString(2));
			cb.setCustAddr(rs.getString(3));
			cb.setCustHp(rs.getString(4));
			
		}
		
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
		<title>고객수정</title>
	</head>
	<body>
		<h3>고객수정</h3>
		
		<a href="/BookStore/index.jsp">처음으로</a>
		<a href="/BookStore/customer/list.jsp">고객목록</a>
		
		<form action="/BookStore/customer/proc/modifyProc.jsp">
			<table border="1">
				<tr>
					<td>고객번호</td>
					<td> <input type="text" name="custId" readonly value="<%=cb.getCustId()%>"/> </td>
				</tr>
				<tr>
					<td>고객명</td>
					<td> <input type="text" name="custName" value="<%=cb.getCustName()%>"/> </td>
				</tr>
				<tr>
					<td>주소</td>
					<td> <input type="text" name="custAddr" value="<%=cb.getCustAddr()%>" />  </td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td> <input type="text" name="custHp" value="<%=cb.getCustHp()%>"/>  </td>
				</tr>
				<tr>
					<td colspan="2" align="right"> <input type="submit" value="수정" /> </td>
				</tr>
			</table>
		</form>
	</body>
</html>
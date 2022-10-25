<%@page import="bean.CustBean"%>
<%@page import="java.io.Console"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//cust DB처리
	List<CustBean> customers = null;
	try{
		Connection conn = DB.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `customer`");
		
		customers = new ArrayList<>();
		
		while(rs.next()){
			CustBean cb = new CustBean();
			
			cb.setCustId(rs.getInt(1));
			cb.setCustName(rs.getString(2));
			cb.setCustAddr(rs.getString(3));
			cb.setCustHp(rs.getString(4));
			
			customers.add(cb);
		}
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객목록</title>
	</head>
	<body>
		<h3>고객목록</h3>
	
		<a href="/BookStore/index.jsp">처음으로</a>
		<a href="/BookStore/customer/register.jsp">고객등록</a>
	
		<table border="1">
			<tr>
				<th>고객번호</th>
				<th>고객명</th>
				<th>주소</th>
				<th>휴대폰</th>
				<th>관리</th>
			</tr>
			<% for(CustBean cb : customers){ %>
			<tr> 
				<td><%= cb.getCustId() %></td>
				<td><%= cb.getCustName() %></td>
				<td><%= cb.getCustAddr() %></td>
				<td><%= cb.getCustHp() %></td>
				<td>
					<a href="/BookStore/customer/modify.jsp?custId=<%= cb.getCustId() %>">수정</a>
					<a href="/BookStore/customer/proc/deleteProc.jsp?custId=<%= cb.getCustId() %>">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>
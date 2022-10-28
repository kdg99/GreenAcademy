<%@page import="java.util.ArrayList"%>
<%@page import="bean.Customer"%>
<%@page import="java.util.List"%>
<%@page import="config.Sql"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Customer> customers = null;
	try{
		customers = new ArrayList<>();
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_CUSTOMERS);
		
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCustId(rs.getString(1));
			customer.setCustName(rs.getString(2));
			customer.setCustHp(rs.getString(3));
			customer.setCustAddr(rs.getString(4));
			customer.setCustDate(rs.getString(5));
			
			customers.add(customer);
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
		<title>Shop::Customer</title>
	</head>
	<body>
	
		<div>
			<h3>고객목록</h3>
			
			<a href="/Shop/customer.jsp">고객목록</a>
			<a href="/Shop/order.jsp">주문목록</a>
			<a href="/Shop/product.jsp">상품목록</a>
			
			<form action="#">
				<table border="1">
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>휴대폰</th>
						<th>주소</th>
						<th>가입일</th>
					</tr>
					<% for(Customer customer : customers){ %>
					<tr>
						<td><%= customer.getCustId() %></td>
						<td><%= customer.getCustName() %></td>
						<td><%= customer.getCustHp() %></td>
						<td><%= customer.getCustAddr() %></td>
						<td><%= customer.getCustDate() %></td>
					</tr>
					<% } %>
					
				</table>
			</form>
		</div>
	</body>
</html>
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="config.Sql"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	List<Product> products = null;
	try{
		products = new ArrayList<>();
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_PRODUCTS);
		
		while(rs.next()){
			Product product = new Product();
			product.setProdNo(rs.getInt(1));
			product.setProdName(rs.getString(2));
			product.setProdStock(rs.getInt(3));
			product.setProdPrice(rs.getInt(4));
			product.setProdCompany(rs.getString(5));
			
			products.add(product);
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
		<title>Shop::Product</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="/Shop/js/createOrderTable.js"></script>
		<script src="/Shop/js/register.js"></script>
		<script>
			$(function(){
				
				//주문테이블 생성
				$(document).on('click', '.order', function(e){
					e.preventDefault();
					createOrderTable($(this).val());
				});
				//주문테이블 생성-end
				
				
				//주문버튼
				$(document).on('click', 'input[type=submit]', function(e){
					e.preventDefault();
					order();
				});
				//주문버튼-end
				
			});
		</script>
	</head>
	<body>
	
		<div id="wrapper">
			<div class="list">
				<h3>상품목록</h3>
				
				<a href="/Shop/customer.jsp">고객목록</a>
				<a href="/Shop/order.jsp">주문목록</a>
				<a href="/Shop/product.jsp">상품목록</a>
				
				<form action="#">
					<table border="1">
						<tr>
							<th>상품번호</th>
							<th>상품명</th>
							<th>재고량</th>
							<th>가격</th>
							<th>제조사</th>
							<th>주문</th>
						</tr>
						<% for(Product product : products){ %>
						<tr>
							<td><%= product.getProdNo() %></td>
							<td><%= product.getProdName() %></td>
							<td><%= product.getProdStock() %></td>
							<td><%= product.getProdPrice() %></td>
							<td><%= product.getProdCompany() %></td>
							<td><button type="button" class="order" value="<%= product.getProdNo() %>">주문</button></td>
						</tr>
						<% } %>
						
					</table>
				</form>
			</div>
			<div class="orderTable">
			</div>
		</div>
	</body>
</html>
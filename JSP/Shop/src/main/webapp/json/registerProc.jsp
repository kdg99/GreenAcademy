<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="config.Sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String custId = request.getParameter("custId");
	String prodNo = request.getParameter("prodNo");
	String count = request.getParameter("count");
	
	int result = 0;
	int orderNo = 0;
	
	try{
		
		Connection conn = DBCP.getConnection();
		
		//주문 번호 가져오기
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_COUNT_ORDERNO);
		if(rs.next()){
			orderNo = rs.getInt(1)+1;
		}
		
		//주문 등록
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ORDER);
		psmt.setInt(1, orderNo);
		psmt.setString(2, custId);
		psmt.setString(3, prodNo);
		psmt.setString(4, count);
		
		result = psmt.executeUpdate();
		
		rs.close();
		stmt.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	JsonObject json = new JsonObject();
	json.addProperty("result", result);
	String jsonData = json.toString();

	out.print(jsonData);
	
%>
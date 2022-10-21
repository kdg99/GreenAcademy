<%@page import="javax.websocket.SendResult"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DB"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int custId = Integer.parseInt(request.getParameter("custId"));
	String custName = request.getParameter("custName");
	String custAddr = request.getParameter("custAddr");
	String custHp = request.getParameter("custHp");

	try{
		Connection conn = DB.getConnection();
		
		String	sql  = "UPDATE `customer` SET `custName`=?, `custAddr`=?, `custHp`=? ";
	 	 		sql += "WHERE `custId`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, custName);
		psmt.setString(2, custAddr);
		psmt.setString(3, custHp);
		psmt.setInt(4, custId);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("/BookStore/customer/list.jsp");
%>
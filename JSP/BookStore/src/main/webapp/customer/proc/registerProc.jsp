<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String custName = request.getParameter("custName");
	String custAddr = request.getParameter("custAddr");
	String custHp = request.getParameter("custHp");
	
	try{
		Connection conn = DB.getConnection();
		
		String	sql  = "INSERT INTO `customer` SET `custName`=?, `custAddr`=?, `custHp`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, custName);
		psmt.setString(2, custAddr);
		psmt.setString(3, custHp);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();		
	}
	catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("/BookStore/customer/list.jsp");
	
%>
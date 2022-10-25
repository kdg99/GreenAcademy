<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.BookBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int bookId = Integer.parseInt(request.getParameter("bookId"));
	
	BookBean bb = null;
	try{
		Connection conn = DB.getConnection();
		String sql = "DELETE FROM `book` WHERE `bookId`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, bookId);
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("/BookStore/book/list.jsp");
	
%>
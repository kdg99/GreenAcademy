<%@page import="config.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송데이터 수신
	request.setCharacterEncoding("utf-8");

	String stdNo = request.getParameter("stdNo");

	//DB 처리
	
	
	try{
		Connection conn = DB.getInstance().getConnection();
		String sql = "DELETE FROM `student` WHERE `stdNo`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, stdNo);
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
	
	//리다이렉트
	response.sendRedirect("./list.jsp");
	
%>
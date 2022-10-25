<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");

	String stdNo = request.getParameter("stdNo");
	String stdName = request.getParameter("stdName");
	String stdHp = request.getParameter("stdHp");
	int stdYear = Integer.parseInt(request.getParameter("stdYear"));
	String stdAddress = request.getParameter("stdAddress");
	

	//DB 처리
	
	try{
		Connection conn = DB.getInstance().getConnection();
		String sql = "INSERT INTO `student` VALUES (?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, stdNo);
		psmt.setString(2, stdName);
		psmt.setString(3, stdHp);
		psmt.setInt(4, stdYear);
		psmt.setString(5, stdAddress);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
	//리다이렉트
	response.sendRedirect("./register.jsp");
	
%>
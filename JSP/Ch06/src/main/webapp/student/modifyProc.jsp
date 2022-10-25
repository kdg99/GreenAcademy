<%@page import="kr.co.jboard1.config.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//전송데이터 수신
	request.setCharacterEncoding("utf-8");
	
	String stdNo = request.getParameter("stdNo");
	String stdName = request.getParameter("stdName");
	String stdHp = request.getParameter("stdHp");
	int stdYear = Integer.parseInt(request.getParameter("stdYear"));
	String stdAddress = request.getParameter("stdAddress");
	
	
	
	try{
		Connection conn = DB.getInstance().getConnection();
		
		String	 sql  = "UPDATE `student` SET `stdName`=?, `stdHp`=?, `stdYear`=?, `stdAddress`=?";
			 	 sql += " WHERE `stdNo`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, stdName);
		psmt.setString(2, stdHp);
		psmt.setInt(3, stdYear);
		psmt.setString(4, stdAddress);
		psmt.setString(5, stdNo);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("./list.jsp");

%>
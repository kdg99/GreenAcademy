<%@page import="config.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//전송데이터 수신
	request.setCharacterEncoding("utf-8");
	
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	int age = Integer.parseInt(request.getParameter("age")); 
	String addr = request.getParameter("addr");
	String hp = request.getParameter("hp");
	
	
	
	try{
		Connection conn = DB.getInstance().getDBCP();
		
		String	 sql  = "UPDATE `user5` SET `name`=?, `birth`=?, `age`=?, `address`=?, `hp`=?";
			 	 sql += " WHERE `uid`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, birth);
		psmt.setInt(3, age);
		psmt.setString(4, addr);
		psmt.setString(5, hp);
		psmt.setString(6, uid);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("./list.jsp");

%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	int age = Integer.parseInt(request.getParameter("age")); 
	String addr = request.getParameter("addr");
	String hp = request.getParameter("hp");
	
	//DB 작업
	try{
		//1단계 - JNDI 서비스 객체 생성
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env");
		
		//2단계 - 커넥션 풀 얻기
		DataSource ds = (DataSource) ctx.lookup("dbcp_java1db");
		Connection conn = ds.getConnection();
		
		//3단계
		String sql = "INSERT INTO `user5` VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, birth);
		psmt.setInt(4, age);
		psmt.setString(5, addr);
		psmt.setString(6, hp);
				
		
		//4단계
		psmt.executeUpdate();
		
		//5단계
		
		
		//6단계
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	//리다이렉트
	response.sendRedirect("./list.jsp");
%>
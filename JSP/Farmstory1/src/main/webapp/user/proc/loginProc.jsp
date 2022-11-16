<%@page import="kr.co.farmstory1.dao.UserDAO"%>
<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="kr.co.farmstory1.bean.UserBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.farmstory1.config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	UserBean ub = UserDAO.getInstance().selectUser(uid, pass);
	
	if(ub != null){
		//로그인 정보가 맞는 경우
		session.setAttribute("sessUser", ub);
		response.sendRedirect("/Farmstory1/index.jsp");
	}else{
		//로그인 정보가 다른 경우
		response.sendRedirect("/Farmstory1/user/login.jsp?success=100");		
	}
%>
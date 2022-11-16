<%@page import="kr.co.farmstory1.bean.UserBean"%>
<%@page import="kr.co.farmstory1.dao.UserDAO"%>
<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.farmstory1.config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	UserBean ub = new UserBean();

	/*
	String uid 		= request.getParameter("uid");
	String pass 	= request.getParameter("pass1");
	String name 	= request.getParameter("name");
	String nick 	= request.getParameter("nick");
	String email 	= request.getParameter("email");
	String hp 		= request.getParameter("hp");
	String zip		= request.getParameter("zip");
	String addr1	= request.getParameter("addr1");
	String addr2	= request.getParameter("addr2");
	String regip 	= request.getRemoteAddr(); //클라이언트 IP주소
	*/
	
	ub.setUid(request.getParameter("uid"));
	ub.setPass(request.getParameter("pass1"));
	ub.setName(request.getParameter("name"));
	ub.setNick(request.getParameter("nick"));
	ub.setEmail( request.getParameter("email"));
	ub.setHp(request.getParameter("hp"));
	ub.setZip(request.getParameter("zip"));
	ub.setAddr1(request.getParameter("addr1"));
	ub.setAddr2(request.getParameter("addr2"));
	ub.setRegip(request.getRemoteAddr());
	
	UserDAO.getInstance().insertUsers(ub);
	
	//리다이렉트
	response.sendRedirect("/Farmstory1/user/login.jsp");
	
%>
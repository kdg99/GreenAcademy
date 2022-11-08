<%@page import="kr.ac.college.bean.StdBean"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.ac.college.dao.CollegeDAO"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String stdNo		= request.getParameter("stdNo");
	String stdName		= request.getParameter("stdName");
	String stdHp		= request.getParameter("stdHp");
	String stdYear		= request.getParameter("stdYear");
	String stdAddress	= request.getParameter("stdAddress");

	CollegeDAO dao = CollegeDAO.getInstance();
	StdBean sb = new StdBean();
	int result = 0;
	
	sb.setStdNo(stdNo);
	sb.setStdName(stdName);
	sb.setStdHp(stdHp);
	sb.setStdYear(stdYear);
	sb.setStdAddress(stdAddress);
	
	result = dao.insertStudent(sb);
	JsonObject json = new JsonObject();
	json.addProperty("result", result);
	String jsonData = json.toString();

	out.print(jsonData);
	
%>
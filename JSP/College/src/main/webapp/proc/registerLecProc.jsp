<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.ac.college.bean.LecBean"%>
<%@page import="kr.ac.college.dao.CollegeDAO"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String lecNo		= request.getParameter("lecNo");
	String lecName		= request.getParameter("lecName");
	String lecCredit	= request.getParameter("lecCredit");
	String lecTime		= request.getParameter("lecTime");
	String lecClass		= request.getParameter("lecClass");

	CollegeDAO dao = CollegeDAO.getInstance();
	LecBean lb = new LecBean();
	int result = 0;
	
	lb.setLecNo(lecNo);
	lb.setLecName(lecName);
	lb.setLecCredit(lecCredit);
	lb.setLecTime(lecTime);
	lb.setLecClass(lecClass);
	
	result = dao.insertLecture(lb);
	
	JsonObject json = new JsonObject();
	json.addProperty("result", result);
	String jsonData = json.toString();
	
	out.print(jsonData);
%>
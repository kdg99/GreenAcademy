<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("sessUser") == null){
		response.sendRedirect("/Farmstory1/user/login.jsp?success=101");
		return;
	}
%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean sessUser = (UserBean) session.getAttribute("sessUser");

	//비정상적으로 접근한 경우
	if(sessUser == null){
		response.sendRedirect("/JBoard1/user/login.jsp?success=101");
		return; //처리종료
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글수정</title>
    <link rel="stylesheet" href="/JBoard1/css/styleinit.css"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>   
    <style>


    </style>
</head>
<body>
    
    <div id="wrapper">
        <header>
            <h3>Board System v1.0</h3>
            
            <p>
                <span class="nick"><%= sessUser.getNick() %></span>님 반갑습니다.
                <a href="/JBoard1/user/proc/logout.jsp" class="logout">[로그아웃]</a>
            </p>
            
        </header>

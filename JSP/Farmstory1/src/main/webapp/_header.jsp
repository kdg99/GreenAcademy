<%@page import="kr.co.farmstory1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean sessUser = (UserBean) session.getAttribute("sessUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
  
    <title>팜스토리::메인</title>
    <link rel="stylesheet" href="/Farmstory1/css/init.css">
    <link rel="stylesheet" href="/Farmstory1/css/header.css">
    <link rel="stylesheet" href="/Farmstory1/css/main.css">
    <link rel="stylesheet" href="/Farmstory1/css/sub.css">
    <link rel="stylesheet" href="/Farmstory1/css/footer.css">
    
   	<!-- 로그인 -->
    <link rel="stylesheet" href="/Farmstory1/user/css/style.css">
    <link rel="stylesheet" href="/Farmstory1/board/css/style.css">
    <!-- 탭 -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
 	
    <!-- 라이브러리 -->
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>    
    
    
    
</head>
<body>
    <div id="wrapper">
        <header>
            <a href="/Farmstory1/index.jsp" class="logo"><img src="/Farmstory1/img/logo.png" alt="로고"/></a>
            <p>
            	<a href="/Farmstory1/">HOME |</a>
            <% if(sessUser == null) { %>
	                <a href="/Farmstory1/user/login.jsp">로그인 |</a>
	                <a href="/Farmstory1/user/terms.jsp">회원가입 |</a>
            <% } else {%>
			        <span class="nick"><%= sessUser.getNick() %></span>님
	                <a href="/Farmstory1/user/proc/logout.jsp" class="logout">[로그아웃] |</a>
            <% } %>
            	<a href="/Farmstory1/board/list.jsp?group=community&cate=qna">고객센터</a>
            </p>
            
            <img src="/Farmstory1/img/head_txt_img.png" alt="3만원 이상 무료배송"/>


            <ul class="gnb">
                <li><a href="/Farmstory1/introduction/hello.jsp">팜스토리소개</a></li>
                <li><a href="/Farmstory1/board/list.jsp?group=market&cate=market"><img src="/Farmstory1/img/head_menu_badge.png" alt="30%"/>장보기</a></li>
                <li><a href="/Farmstory1/board/list.jsp?group=croptalk&cate=story">농작물이야기</a></li>
                <li><a href="/Farmstory1/board/list.jsp?group=event&cate=event">이벤트</a></li>
                <li><a href="/Farmstory1/board/list.jsp?group=community&cate=notice">커뮤니티</a></li>
            </ul>
        </header>

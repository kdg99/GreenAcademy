<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그인 여부에 따라 페이지 처리 흐름 분기
	if(true){
		//로그인 X
		pageContext.forward("./user/login.jsp");
		
	} else{
		//로그인 O
		pageContext.forward("./list.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
	</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	//전송 데이터 수신
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	//id가 abcd이고 pw가 1234라고 했을 때
	if(pw.equals("1234")){
		//회원 O
		
		// 클라이언트 정보 설정
		session.setAttribute("uid", id);
		response.sendRedirect("./loginSuccess.jsp");
	}else{
		//회원 X
		response.sendRedirect("../6_session.jsp");
	}

%>ㅉㅉㅉ
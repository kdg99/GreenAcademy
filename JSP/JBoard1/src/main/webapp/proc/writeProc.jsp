<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.Sql"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.jboard1.config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");

	//파일수신
	//MultipartRequest mr = new MultipartRequest(request, "경로", "파일최대사이즈", "인코딩값", new DefaultFileRenamePolicy());
	String savePath = application.getRealPath("/file");
	int maxSize = 1024* 1024 * 10; //최대 파일 업로드 허용량 10MB
	MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

	//값 수신
	String title 		= mr.getParameter("title");
	String content 		= mr.getParameter("content");
	String uid			= mr.getParameter("uid");
	String fname = mr.getFilesystemName("fname");
	//그냥 input으로 받아올 것
	//UserBean sessUser 	= (UserBean) session.getAttribute("sessUser");
	String regip 		= request.getRemoteAddr();
	int parent = 0;
	
	try{
		Connection conn = DBCP.getConnection();
		conn.setAutoCommit(false); //동시에 처리해주려고 멈춰둠
		
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
		
		psmt.setString(1, title);
		psmt.setString(2, content);
		psmt.setInt(3, fname == null ? 0 : 1);
		psmt.setString(4, uid);
		psmt.setString(5, regip);
		
		psmt.executeUpdate();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_NO);
		
		conn.commit(); //작업확정
		
		if(rs.next()){
			parent = rs.getInt(1);
		}
		
		rs.close();
		stmt.close();
		psmt.close();
		conn.close();
				
	}catch(Exception e){
		e.printStackTrace();
	}

	// 첨부된 파일의 파일명 수정 작업
	if(fname != null){
		
		//파일명 수정
		//확장자 빼주기
		int idx = fname.lastIndexOf(".");
		String ext = fname.substring(idx);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
		String now = sdf.format(new Date());
		String newFname = now+uid+ext; 
		
		File oriFile = new File(savePath+"/"+fname);
		File newFile = new File(savePath+"/"+newFname);
		
		oriFile.renameTo(newFile);
		
		//파일 테이블 저장
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
			
			psmt.setInt(1, parent);
			psmt.setString(2, newFname);
			psmt.setString(3, fname);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	
	response.sendRedirect("/JBoard1/list.jsp");
	
%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.farmstory1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.farmstory1.config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");

	//Farmstory1
	

	//파일수신
	//MultipartRequest mr = new MultipartRequest(request, "경로", "파일최대사이즈", "인코딩값", new DefaultFileRenamePolicy());
	String savePath = application.getRealPath("/board/file");
	int maxSize = 1024* 1024 * 10; //최대 파일 업로드 허용량 10MB
	MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

	//값 수신
	String title 		= mr.getParameter("title");
	String content 		= mr.getParameter("content");
	String uid			= mr.getParameter("uid");
	String group = mr.getParameter("group");
	String cate = mr.getParameter("cate");
	String fname = mr.getFilesystemName("fname");
	//그냥 input으로 받아올 것
	//UserBean sessUser 	= (UserBean) session.getAttribute("sessUser");
	String regip 		= request.getRemoteAddr();
	
	//게시물추가 명령어
	ArticleBean article = new ArticleBean();
	
	article.setTitle(title);
	article.setContent(content);
	article.setFname(fname);
	article.setUid(uid);
	article.setRegip(regip);
	
	ArticleDAO dao = ArticleDAO.getInstance();
	int parent = dao.insertArticle(article);
	//
	
	// 첨부된 파일의 파일명 수정 작업
	if(fname != null){
		
		//파일명 수정
		//확장자 빼주기
		int idx = fname.lastIndexOf(".");
		String ext = fname.substring(idx);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
		String now = sdf.format(new Date());
		String newName = now+uid+ext; 
		
		File oriFile = new File(savePath+"/"+fname);
		File newFile = new File(savePath+"/"+newName);
		
		oriFile.renameTo(newFile);
		
		//파일 테이블 저장
		dao.insertFile(parent, newName, fname);
	
	}
	
	
	response.sendRedirect("/Farmstory1/board/list.jsp?group="+group+"&cate="+cate);
	
%>
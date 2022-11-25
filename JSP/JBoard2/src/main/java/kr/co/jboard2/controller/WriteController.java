package kr.co.jboard2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.jboard2.dao.ArticleDAO;
import kr.co.jboard2.service.ArticleService;
import kr.co.jboard2.vo.ArticleVO;

@WebServlet("/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ArticleService service = ArticleService.INSTANCE;

	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파일 전송 데이터 수신
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file");
		
		MultipartRequest mr = service.uploadFile(req, path);
		//값 수신
		String title 		= mr.getParameter("title");
		String content 		= mr.getParameter("content");
		String uid			= mr.getParameter("uid");
		String fname 		= mr.getFilesystemName("fname");
		//그냥 input으로 받아올 것
		//UserBean sessUser 	= (UserBean) session.getAttribute("sessUser");
		String regip 		= req.getRemoteAddr();
		
		//게시물추가 명령어
		ArticleVO article = new ArticleVO();
		
		article.setTitle(title);
		article.setContent(content);
		article.setFname(fname);
		article.setUid(uid);
		article.setRegip(regip);
		
		ArticleDAO dao = ArticleDAO.getInstance();
		int parent = service.insertArticle(article);
		
		// 첨부된 파일의 파일명 수정 작업
		if(fname != null){
			//파일명 수정
			String newName = service.renameFile(article, path);
			//파일 테이블 저장
			dao.insertFile(parent, newName, fname);
		}
		
		
		resp.sendRedirect("/JBoard2/list.do");
	}
}

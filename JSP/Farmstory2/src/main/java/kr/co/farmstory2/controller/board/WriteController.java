package kr.co.farmstory2.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.vo.ArticleVO;

@WebServlet("/board/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//파일 전송 데이터 수신
		ServletContext ctx = req.getServletContext();
		String path 	= ctx.getRealPath("/file");
		MultipartRequest mr = service.uploadFile(req, path);
		
		//값수신
		String group 	= mr.getParameter("group");
		String cate 	= mr.getParameter("cate");
		String uid		= mr.getParameter("uid");
		String title 	= mr.getParameter("title");
		String content	= mr.getParameter("content");
		String fname 	= mr.getFilesystemName("fname");
		String regip	= req.getRemoteAddr();
		
		//게시물 추가
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setContent(content);
		article.setUid(uid);
		article.setFname(fname);
		article.setRegip(regip);
		article.setCate(cate);
		int parent = service.insertArticle(article);

		// 첨부된 파일의 파일명 수정 작업
		if(fname != null){
			//파일명 수정
			String newName = service.renameFile(article, path);
			service.insertFile(parent, newName, fname);
		}
		
		resp.sendRedirect("/Farmstory2/board/list.do?group="+group+"&cate="+cate);
	}
	
}

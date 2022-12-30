package kr.co.farmstory2.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.service.ArticleService;

@WebServlet("/board/commentWrite.do")
public class CommentWriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group 	= req.getParameter("group");
		String cate 	= req.getParameter("cate");
		String pg 		= req.getParameter("pg");
		String parent 	= req.getParameter("parent");
		String content 	= req.getParameter("content");
		String uid 		= req.getParameter("uid");
		String regip	= req.getRemoteAddr();
		
		service.insertComment(parent, content, uid, regip);
		resp.sendRedirect("/Farmstory2/board/view.do?group="+group+"&cate="+cate+"&pg="+pg+"&no="+parent);
	}
	
}

package kr.co.farmstory2.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.service.ArticleService;

@WebServlet("/board/commentDelete.do")
public class CommentDeleteController extends HttpServlet{
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
		
		service.deleteComment(parent);
		resp.sendRedirect("/Farmstory2/board/view.do?group="+group+"&cate="+cate+"&pg="+pg+"&no="+parent);
	}
	
}

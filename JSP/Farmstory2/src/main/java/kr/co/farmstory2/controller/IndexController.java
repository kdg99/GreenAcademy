package kr.co.farmstory2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.vo.ArticleVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ArticleService service = ArticleService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ArticleVO> growList = service.selectArticles(0, "grow", 5);
		List<ArticleVO> schoolList = service.selectArticles(0, "school", 5);
		List<ArticleVO> storyList = service.selectArticles(0, "story", 5);
		List<ArticleVO> noticeList = service.selectArticles(0, "notice", 3);
		List<ArticleVO> qnaList = service.selectArticles(0, "qna", 3);
		List<ArticleVO> faqList = service.selectArticles(0, "faq", 3);
		
		req.setAttribute("growList", growList);
		req.setAttribute("schoolList", schoolList);
		req.setAttribute("storyList", storyList);
		req.setAttribute("noticeList", noticeList);
		req.setAttribute("qnaList", qnaList);
		req.setAttribute("faqList", faqList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}


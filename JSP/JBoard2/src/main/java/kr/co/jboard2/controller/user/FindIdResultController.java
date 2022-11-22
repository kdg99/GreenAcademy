package kr.co.jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.UserDAO;
import kr.co.jboard2.vo.UserVO;

@WebServlet("/user/findIdResult.do")
public class FindIdResultController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/findIdResult.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		UserVO findUser = null;
		findUser = UserDAO.getInstance().findId(name, email);

		if(findUser != null){
			//회원 맞으면
			System.out.println(findUser+"회원임");
			req.setAttribute("findUser", findUser);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/findIdResult.jsp");
			dispatcher.forward(req, resp);
		}else {
			System.out.println(findUser);
			//회원 아니면
			//resp.sendRedirect("/JBoard2/user/findId.do?success=201");		
			resp.sendRedirect("/WEB-INF/user/findId.jsp?success=201");		
		}
	}
}

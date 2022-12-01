package kr.co.farmstory2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.service.UserService;
import kr.co.farmstory2.vo.UserVO;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UserService service = UserService.INSTANCE;

	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String auto = req.getParameter("auto");
		
		//로그인처리
		UserVO login = service.selectUser(uid, pass);
		if(login != null){
			//회원 맞으면
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", login);
			
			//자동로그인 확인 후 클라이언트 고유값 확인
			if(auto != null) {
				String sessId = session.getId();

				//쿠키생성
				Cookie cookie = new Cookie("SESSID", sessId);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*3);
				resp.addCookie(cookie);
				
				//세선정보 데이터베이스 저장
				//dao.updateUserForSession(sessId, uid);
			}
			
			resp.sendRedirect("/Farmstory2/index.do");
		}else {
			//회원 아니면
			resp.sendRedirect("/Farmstory2/user/login.do?success=100");		
		}
	}
	
}

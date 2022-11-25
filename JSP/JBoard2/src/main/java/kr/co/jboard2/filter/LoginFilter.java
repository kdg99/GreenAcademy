package kr.co.jboard2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.dao.UserDAO;
import kr.co.jboard2.vo.UserVO;

//내부 모든 요청에서 필터 동작
@WebFilter("/*")
public class LoginFilter implements Filter{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("LoginFilter ...");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession sess = req.getSession();
		sess.removeAttribute("findUser");
		
		//자동로그인 여부에 따라 로그인 처리
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("SESSID")) {
					String sessId = cookie.getValue();
					UserVO user = UserDAO.getInstance().selectUserBySessId(sessId);
					
					if(user != null) {
						sess.setAttribute("sessUser", user);
					}
				}
			}
		}
		
		chain.doFilter(request, response);
		
		/*
		//로그인 여부에 따라 페이지 이동
		UserVO sessUser = (UserVO)sess.getAttribute("sessUser");
		if(sessUser == null) {
			((HttpServletResponse)response).sendRedirect("/JBoard2/user/login.do");
		}else {
			//다음 필터로 넘어가기
			//chain.doFilter(request, response);
		}*/
	}
}

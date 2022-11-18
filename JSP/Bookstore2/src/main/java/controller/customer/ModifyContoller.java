package controller.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import vo.CustomerVO;


@WebServlet("/customer/modify.do")
public class ModifyContoller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId = req.getParameter("custId");
		CustomerVO customer = CustomerDAO.getInstance().selectCustomer(custId);
		req.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId = req.getParameter("custId");
		String custName = req.getParameter("custName");
		String custAddr = req.getParameter("custAddr");
		String custHp = req.getParameter("custHp");
		
		CustomerVO customer = new CustomerVO();
		customer.setCustId(custId);
		customer.setCustName(custName);
		customer.setCustAddr(custAddr);
		customer.setCustHp(custHp);
		
		CustomerDAO.getInstance().updateCustomer(customer);
		resp.sendRedirect("/Bookstore2/customer/list.do");
	}
}

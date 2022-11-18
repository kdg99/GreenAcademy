package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DBHelper;
import db.Sql;
import vo.CustomerVO;

public class CustomerDAO extends DBHelper{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	private CustomerDAO() {}
	//
	public CustomerVO 		selectCustomer(String custId) {
		logger.debug("selectCustomer Start...");
		CustomerVO customer = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER);
			psmt.setString(1, custId);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				customer = new CustomerVO();
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustAddr(rs.getString(3));
				customer.setCustHp(rs.getString(4));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("selectCustomer end...");
		return customer;
	}
	//
	public List<CustomerVO> selectCustomers() {
		logger.debug("selectCustomers Start...");
		List<CustomerVO> customers = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CUSTOMERS);
			
			while(rs.next()) {
				CustomerVO customer = new CustomerVO();
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustAddr(rs.getString(3));
				customer.setCustHp(rs.getString(4));
				customers.add(customer);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("selectCustomers end...");
		return customers;
	}
	//
	public void 			updateCustomer(CustomerVO customer) {
		logger.debug("updateCustomer Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_CUSTOMER);
			psmt.setString(1, customer.getCustName());
			psmt.setString(2, customer.getCustAddr());
			psmt.setString(3, customer.getCustHp());
			psmt.setInt(4, customer.getCustId());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("updateCustomer end...");
	}
	//
	public void 			insertCustomer(CustomerVO customer) {
		logger.debug("insertCustomer Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_CUSTOMER);
			psmt.setInt(1, customer.getCustId());
			psmt.setString(2, customer.getCustName());
			psmt.setString(3, customer.getCustAddr());
			psmt.setString(4, customer.getCustHp());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("insertCustomer end...");
	}
	//
	public void 		deleteCustomer(String custId) {
		logger.debug("deleteCustomer Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_CUSTOMER);
			psmt.setString(1, custId);
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("deleteCustomer end...");
	}
}

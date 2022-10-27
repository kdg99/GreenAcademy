package kr.co.jboard1.dao;

public class UserDAO {

	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {};
	
	//기본 CRUD
	public void insertArticle() {}
	public void selectArticle() {}
	public void selectArticles() {
		
		
		
	}
	public void updateArticle() {}
	public void deleteArticle() {}
	
}

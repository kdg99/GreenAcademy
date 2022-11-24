package kr.co.jboard2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.Sql;
import kr.co.jboard2.vo.ArticleVO;

public class ArticleDAO extends DBHelper{
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	//로거
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//
	public ArticleVO selectArticle(String no) {
		ArticleVO article = null;
		try {
			logger.info("selectArticle start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11).substring(2,10));
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return article;
	}
	
	//
	public List<ArticleVO> selectArticles(int start) {
		List<ArticleVO> articles = null;  
		try{
			conn = getConnection();
			articles = new ArrayList<>();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11).substring(2,10));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			close();
			}catch(Exception e){
				logger.error(e.getMessage());
			}
		return articles;
	}
	
	//
	public void updateUserForSession(String sessId, String uid) {
		
		try {
			logger.info("updateUserForSession start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_USER_FOR_SESSION);
			psmt.setString(1, sessId);
			psmt.setString(2, uid);
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteUser() {}
}

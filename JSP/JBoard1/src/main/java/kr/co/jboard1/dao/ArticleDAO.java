package kr.co.jboard1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.bean.ArticleBean;
import kr.co.jboard1.bean.FileBean;
import kr.co.jboard1.config.DBCP;
import kr.co.jboard1.config.Sql;

public class ArticleDAO {

	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {

		
	};
	
	//기본 CRUD
	public int insertArticle(ArticleBean article) {
		int parent = 0;
		
		try{
			Connection conn = DBCP.getConnection();
			conn.setAutoCommit(false); //동시에 처리해주려고 멈춰둠
			
			Statement stmt = conn.createStatement();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setInt(3, article.getFname() == null ? 0 : 1);
			psmt.setString(4, article.getUid());
			psmt.setString(5, article.getRegip());
			
			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_NO);
			
			conn.commit(); //작업확정
			
			if(rs.next()){
				parent = rs.getInt(1);
			}
			
			rs.close();
			stmt.close();
			psmt.close();
			conn.close();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return parent;
	}
	
	public void insertFile(int parent, String newName, String fname) {
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
			
			psmt.setInt(1, parent);
			psmt.setString(2, newName);
			psmt.setString(3, fname);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArticleBean insertComment(ArticleBean comment) {
		
		ArticleBean article = null;
		
		try{
			
			Connection conn = DBCP.getConnection();
			//트랜잭션시작
			conn.setAutoCommit(false);
			
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
			Statement stmt = conn.createStatement();
			
			psmt.setInt(1, comment.getParent());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getUid());
			psmt.setString(4, comment.getRegip());
			
			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_COMMENT_LATEST);
			
			//트랜잭션 작업 확정
			conn.commit();
			
			if(rs.next()) {
				article = new ArticleBean();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setContent(rs.getString(6));
				article.setRdate(rs.getString(11).substring(2,10));
				article.setNick(rs.getString(12));
				
			}
			
			rs.close();
			stmt.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return article;
	}
	
	public ArticleBean selectArticle(String no) {
		ArticleBean article = null;
		try{
			
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				article = new ArticleBean();
				
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
				article.setRdate(rs.getString(11));
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
				
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return article;
	}
	
	public List<ArticleBean> selectArticles(int start) {
		
		List<ArticleBean> articles = null;
		
		try{
			Connection conn = DBCP.getConnection();
			
			//게시글가져오기
			articles = new ArrayList<>();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				ArticleBean article = new ArticleBean();
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
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return articles;
		
	}//select articles-end
	public void updateArticle() {}
	public void deleteArticle() {}
	
	// 전체 게시물 카운트
	public int selectCountTotal() {
		
		int total = 0;
		
		try{
			Connection conn = DBCP.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);
			
			if(rs.next()){
				total = rs.getInt(1);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return total;
	}
	
	public FileBean selectFile(String fno) {
		FileBean fb = null;
		try{
			
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, fno);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				
				fb = new FileBean();
				fb.setFno(rs.getInt(1));
				fb.setParent(rs.getInt(2));
				fb.setNewName(rs.getString(3));
				fb.setOriName(rs.getString(4));
				fb.setFno(rs.getInt(5));
				fb.setRdate(rs.getString(6));
			
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return fb;
	}
	
public List<ArticleBean> selectComments(String parent) {
		
		List<ArticleBean> comments = null;
		
		try{
			Connection conn = DBCP.getConnection();
			
			//게시글가져오기
			comments = new ArrayList<>();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
			psmt.setString(1, parent);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				ArticleBean comment = new ArticleBean();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setComment(rs.getInt(3));
				comment.setCate(rs.getString(4));
				comment.setTitle(rs.getString(5));
				comment.setContent(rs.getString(6));
				comment.setFile(rs.getInt(7));
				comment.setHit(rs.getInt(8));
				comment.setUid(rs.getString(9));
				comment.setRegip(rs.getString(10));
				comment.setRdate(rs.getString(11).substring(2,10));
				comment.setNick(rs.getString(12));
				
				comments.add(comment);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return comments;
		
	}//select articles-end
	
	public void updateArticleHit(String no) {
		try{	
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	// 다운로드 카운트
	public void updateFileDownload(String fno) {
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, fno);
			psmt.executeUpdate();

			psmt.close();
			conn.close();
		}catch(Exception e){
			 e.printStackTrace();
		}
	}
	
	
}

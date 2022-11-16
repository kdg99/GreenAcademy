package kr.co.farmstory1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory1.bean.ArticleBean;
import kr.co.farmstory1.bean.FileBean;
import kr.co.farmstory1.config.DBCP;
import kr.co.farmstory1.config.Sql;

public class ArticleDAO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {};
	
	//기본 CRUD
	public int insertArticle(ArticleBean article) {
		int parent = 0;
		
		try{
			logger.debug("insertArticle start...");
			Connection conn = DBCP.getConnection();
			conn.setAutoCommit(false); //동시에 처리해주려고 멈춰둠
			
			Statement stmt = conn.createStatement();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			
			psmt.setString(1, article.getCate());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getContent());
			psmt.setInt(4, article.getFname() == null ? 0 : 1);
			psmt.setString(5, article.getUid());
			psmt.setString(6, article.getRegip());
			
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
			logger.error(e.getMessage());
		}
		logger.debug("insertArticle end...");
		return parent;
	}
	
	//파일업로드
	public void insertFile(int parent, String newName, String fname) {
		try{
			logger.debug("insertFile start...");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
			
			psmt.setInt(1, parent);
			psmt.setString(2, newName);
			psmt.setString(3, fname);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	//댓글등록
	public ArticleBean insertComment(ArticleBean comment) {
		
		ArticleBean article = null;
		
		try{
			logger.debug("insertComment start...");
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
			logger.error(e.getMessage());
		}
		
		return article;
	}
	
	public ArticleBean selectArticle(String no) {
		logger.debug("selectArticle start...");
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
				article.setRdate(rs.getString(11).substring(2,10));
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
				
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug("selectArticle end...");
		return article;
	}
	
	public List<ArticleBean> selectArticles(String cate, int start) {
		logger.debug("selectArticles start...");
		List<ArticleBean> articles = null;
		
		try{
			Connection conn = DBCP.getConnection();
			
			//게시글가져오기
			articles = new ArrayList<>();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
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
				article.setRdate(rs.getString(11).substring(2,10));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.debug("selectArticles end...");
		return articles;
		
	}//select articles-end
	
	//게시글 수정
	public void updateArticle(String no, String title, String content) {
		logger.debug("updateArticle start...");
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	//게시글 삭제
	public void deleteArticle(String no) {
		logger.debug("deleteArticle start...");
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	//파일 삭제
	public String deleteFile(String parent) {
		logger.debug("deleteFile start...");
		String newName= null;
		try {
			Connection conn = DBCP.getConnection();
			
			conn.setAutoCommit(false);
			
			PreparedStatement psmt1 = conn.prepareStatement(Sql.SELECT_FILE_WITH_PARENT);
			PreparedStatement psmt2 = conn.prepareStatement(Sql.DELETE_FILE);
			psmt1.setString(1, parent);
			psmt2.setString(1, parent);
			
			ResultSet rs = psmt1.executeQuery();
			psmt2.executeUpdate();
			
			conn.commit();
			
			if(rs.next()) {
				newName = rs.getString(3);
			}
			
			rs.close();
			psmt1.close();
			psmt2.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return newName;
	}
	
	// 전체 게시물 카운트
	public int selectCountTotal(String cate) {
		logger.debug("selectCountTotal start...");
		int total = 0;
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);

			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			rs.close();
			psmt.close();
			conn.close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.debug("selectCountTotal end...");
		return total;
	}
	
	public FileBean selectFile(String fno) {
		logger.debug("selectFile start...");
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
			logger.error(e.getMessage());
		}
		
		return fb;
	}
	
	//댓글선택
	public List<ArticleBean> selectComments(String parent) {
		logger.debug("selectComments start...");
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
			logger.error(e.getMessage());
		}
		
		return comments;
		
	}//select articles-end
	
	//조회수증가
	public void updateArticleHit(String no) {
		logger.debug("updateArticleHit start...");
		try{	
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	
	// 다운로드 카운트
	public void updateFileDownload(String fno) {
		logger.debug("updateFileDownload start...");
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, fno);
			psmt.executeUpdate();

			psmt.close();
			conn.close();
		}catch(Exception e){
			 e.printStackTrace();
			 logger.error(e.getMessage());
		}
	}
	
	// 댓글 수정
	public int updateComment(String no, String content) {
		logger.debug("updateComment start...");
		int result = 0;
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, no);
			result = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}
	
	// 댓글 삭제
	public int deleteComment(String no) {
		logger.debug("deleteComment start...");
		int result = 0;
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_COMMENT);
			psmt.setString(1, no);
			result = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}
	/*
	public int countComments(String no) {
		logger.info("countComments start...");
		int result = 0;
		
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_COMMENTS);
			psmt.setString(1, no);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return result;
		
	}*/
	
}

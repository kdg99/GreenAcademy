package kr.co.farmstory2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.db.Sql;
import kr.co.farmstory2.vo.ArticleVO;
import kr.co.farmstory2.vo.FileVO;

public class ArticleDAO extends DBHelper{
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {

		
	};
	
	
	public int insertArticle(ArticleVO article) {
		int parent = 0;
		
		try{
			logger.info("insertArticle start...");
			conn = getConnection();
			conn.setAutoCommit(false); //동시에 처리해주려고 멈춰둠
			
			Statement stmt = conn.createStatement();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setInt(3, article.getFname() == null ? 0 : 1);
			psmt.setString(4, article.getUid());
			psmt.setString(5, article.getRegip());
			psmt.setString(6, article.getCate());
			
			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_NO); //최신 버노가져옴
			
			conn.commit(); //작업확정
			
			if(rs.next()){
				parent = rs.getInt(1);
			}
			
			close();
					
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return parent;
	}
	
	//파일업로드
	public void insertFile(int parent, String newName, String fname) {
		try{
			logger.info("insertFile start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_FILE);
			
			psmt.setInt(1, parent);
			psmt.setString(2, newName);
			psmt.setString(3, fname);
			
			psmt.executeUpdate();
			close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	//
	public ArticleVO selectArticle(String no) {
		logger.info("selectArticle start...");
		ArticleVO article = null;
		try{
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			if(rs.next()){
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
				article.setRdate(rs.getString(11).substring(2,11));
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
				
			}
			
			close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return article;
	}
	
	public List<ArticleVO> selectArticles(int start, String cate, int amount) {
		logger.info("selectArticles start..."+ cate + " start=" + start);
		List<ArticleVO> articles = null;
		try{
			conn = getConnection();
			//게시글가져오기
			articles = new ArrayList<>();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			psmt.setInt(3, amount);
			rs = psmt.executeQuery();
			
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
				article.setRdate(rs.getString(11).substring(2,11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.info("selectArticles end... total=" + articles.size());
		return articles;
		
	}//select articles-end
	
	public List<ArticleVO> selectArticleByKeyword(String keyword, int start, String cate, int amount) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticleByKeyword start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_BY_KEYWORD);
			psmt.setString(1, cate);
			psmt.setString(2, "%"+keyword+"%");
			psmt.setString(3, "%"+keyword+"%");
			psmt.setInt(4, start);
			psmt.setInt(5, amount);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
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
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	//게시글 수정
	public void updateArticle(String no, String title, String content) {
		logger.info("updateArticle start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			psmt.executeUpdate();
			
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//게시글 삭제
	public void deleteArticle(String no) {
		logger.info("deleteArticle start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			close();
			
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	//파일 삭제
	public String deleteFile(String parent) {
		logger.info("deleteFile start...");
		String newName= null;
		try {
			conn = getConnection();
			
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
			
			psmt1.close();
			psmt2.close();
			close();
			
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		return newName;
	}
	
	// 전체 게시물 카운트
	public int selectCountTotal(String cate) {
		logger.info("selectCountTotal start...");
		int total = 0;
		
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				total = rs.getInt(1);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return total;
	}
	//검색 게시물 카운트
	public int selectCountTotalForSearch(String keyword, String cate) {
		logger.info("selectCountTotalForSearch start...");
		int total = 0;
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_FOR_SEARCH);
			psmt.setString(1, cate);
			psmt.setString(2, "%"+keyword+"%");
			psmt.setString(3, "%"+keyword+"%");
			rs = psmt.executeQuery();
			
			if(rs.next()){
				total = rs.getInt(1);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return total;
	}
	
	public FileVO selectFile(String fno) {
		logger.info("selectFile start...");
		FileVO fb = null;
		try{
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, fno);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				
				fb = new FileVO();
				fb.setFno(rs.getInt(1));
				fb.setParent(rs.getInt(2));
				fb.setNewName(rs.getString(3));
				fb.setOriName(rs.getString(4));
				fb.setFno(rs.getInt(5));
				fb.setRdate(rs.getString(6));
			
			}
			close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return fb;
	}
	
	//댓글선택
	public List<ArticleVO> selectComments(String parent) {
		logger.info("selectComments start...");
		List<ArticleVO> comments = null;
		
		try{
			conn = getConnection();
			
			//게시글가져오기
			comments = new ArrayList<>();
			psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
			psmt.setString(1, parent);
			rs = psmt.executeQuery();
			
			while(rs.next()){
				ArticleVO comment = new ArticleVO();
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
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return comments;
	}
	
	//조회수증가
	public void updateArticleHit(String no) {
		logger.info("updateArticleHit start...");
		try{	
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			
			close();
			
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	
	// 다운로드 카운트
	public void updateFileDownload(String fno) {
		logger.info("updateFileDownload start...");
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, fno);
			psmt.executeUpdate();

			close();
		}catch(Exception e){
			 logger.error(e.getMessage());
		}
	}
	
	

	
	//댓글
	//댓글등록
		public ArticleVO insertComment(ArticleVO comment, String parent) {
			ArticleVO article = null;
			try{
				logger.info("insertComment start...");
				conn = getConnection();
				//트랜잭션시작
				conn.setAutoCommit(false);
				
				psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
				PreparedStatement psmt2 = conn.prepareStatement(Sql.UPDATE_ARTICLE_COMMENT);
				stmt = conn.createStatement();
				
				psmt.setInt(1, comment.getParent());
				psmt.setString(2, comment.getContent());
				psmt.setString(3, comment.getUid());
				psmt.setString(4, comment.getRegip());
				psmt2.setString(1, parent);
				psmt2.setString(2, parent);
				
				psmt.executeUpdate();
				psmt2.executeUpdate();
				rs = stmt.executeQuery(Sql.SELECT_COMMENT_LATEST);
				
				//트랜잭션 작업 확정
				conn.commit();
				
				if(rs.next()) {
					article = new ArticleVO();
					article.setNo(rs.getInt(1));
					article.setParent(rs.getInt(2));
					article.setContent(rs.getString(6));
					article.setRdate(rs.getString(11).substring(2,10));
					article.setNick(rs.getString(12));
				}
				psmt2.close();
				close();
			}catch(Exception e){
				logger.error(e.getMessage());
			}
			return article;
		}
		
		// 댓글 수정
		public int updateComment(String no, String content) {
			logger.info("updateComment start...");
			int result = 0;
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.UPDATE_COMMENT);
				psmt.setString(1, content);
				psmt.setString(2, no);
				result = psmt.executeUpdate();
				
				close();
				
			} catch(Exception e) {
				logger.error(e.getMessage());
			}
			return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}
		
		// 댓글 삭제
		public int deleteComment(String parent) {
			logger.info("deleteComment start...");
			int result = 0;
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.DELETE_COMMENT);
				PreparedStatement psmt2 = conn.prepareStatement(Sql.UPDATE_ARTICLE_COMMENT);
				psmt.setString(1, parent);
				psmt2.setString(1, parent);
				psmt2.setString(2, parent);
				result = psmt.executeUpdate();
				
				psmt2.close();
				close();
				
			} catch(Exception e) {
				logger.error(e.getMessage());
			}
			return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}
	
}

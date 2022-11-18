package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DBHelper;
import db.Sql;
import vo.BookVO;

public class BookDAO extends DBHelper{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	private BookDAO() {}
	//
	public BookVO 		selectBook(String bookId) {
		logger.debug("selectBook Start...");
		BookVO book = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_BOOK);
			psmt.setString(1, bookId);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				book = new BookVO();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setPrice(rs.getInt(4));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("selectBook end...");
		return book;
	}
	//
	public List<BookVO> selectBooks() {
		logger.debug("selectBooks Start...");
		List<BookVO> books = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_BOOKS);
			
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setPrice(rs.getInt(4));
				books.add(book);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("selectBooks end...");
		return books;
	}
	//
	public void 		updateBook(BookVO book) {
		logger.debug("updateBook Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_BOOK);
			psmt.setString(1, book.getBookName());
			psmt.setString(2, book.getPublisher());
			psmt.setInt(3, book.getPrice());
			psmt.setInt(4, book.getBookId());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("updateBook end...");
	}
	//
	public void 		insertBook(BookVO book) {
		logger.debug("insertBook Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_BOOK);
			psmt.setInt(1, book.getBookId());
			psmt.setString(2, book.getBookName());
			psmt.setString(3, book.getPublisher());
			psmt.setInt(4, book.getPrice());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("deleteBook end...");
	}
	//
	public void 		deleteBook(String bookId) {
		logger.debug("deleteBook Start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_BOOK);
			psmt.setString(1, bookId);
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("deleteBook end...");
	}
}

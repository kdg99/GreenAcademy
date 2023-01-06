package kr.co.bookstore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bookstore.vo.BookVO;

@Repository
public class BookDAO {

	@Autowired
	private SqlSessionTemplate mb;
	
	public void insertBook(BookVO vo) {
		mb.insert("bookstore.insertBook", vo);
	}
	public BookVO selectBook(String id) {
		return mb.selectOne("bookstore.selectBook", id);
	}
	public List<BookVO> selectBooks() {
		return mb.selectList("bookstore.selectBooks");
	}
	public void updateBook(BookVO vo) {
		mb.update("bookstore.updateBook", vo);
	}
	public void deleteBook(String id) {
		mb.delete("bookstore.deleteBook", id);
	}
}

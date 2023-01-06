package kr.co.bookstore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bookstore.vo.CustVO;

@Repository
public class CustDAO {

	@Autowired
	private SqlSessionTemplate mb;
	
	public void insertCust(CustVO vo) {
		mb.insert("bookstore.insertCust", vo);
	}
	public CustVO selectCust(String id) {
		return mb.selectOne("bookstore.selectCust", id);
	}
	public List<CustVO> selectCusts() {
		return mb.selectList("bookstore.selectCusts");
	}
	public void updateCust(CustVO vo) {
		mb.update("bookstore.updateCust", vo);
	}
	public void deleteCust(String id) {
		mb.delete("bookstore.deleteCust", id);
	}
}

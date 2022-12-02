package kr.co.farmstory2.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.dao.ArticleDAO;
import kr.co.farmstory2.vo.ArticleVO;

public enum ArticleService {
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	
	//write
	public MultipartRequest uploadFile(HttpServletRequest req, String path) throws IOException {
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용량 10MB
		return new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	}
	
	public int insertArticle(ArticleVO article) {
		return dao.insertArticle(article);
	}
	
	public String renameFile(ArticleVO vo, String path) {
		// 파일명 수정
		int idx = vo.getFname().lastIndexOf(".");
		String ext = vo.getFname().substring(idx);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
		String now = sdf.format(new Date());
		String newName = now+vo.getUid()+ext; // 20221026111323_chhak0503.txt 
		
		File oriFile = new File(path+"/"+vo.getFname());
		File newFile = new File(path+"/"+newName);
		
		oriFile.renameTo(newFile);
		
		return newName;
	}
	
	public void insertFile(int parent, String newName, String fname) {
		dao.insertFile(parent, newName, fname);
	}
	
	//view
	public ArticleVO selectArticle(String no){
		return dao.selectArticle(no);
	}
	
	public void deleteArticle(String no){
		dao.deleteArticle(no);
	}
	
	public void updateArticle(String no, String title, String content) {
		dao.updateArticle(no, title, content);
	}
	
	//list
	public List<ArticleVO> selectArticles(int start, String cate, int amount){
		return dao.selectArticles(start, cate, amount);
	}
	
	public List<ArticleVO> selectArticleByKeyword(String keyword, int start, String cate, int amount) {
		return dao.selectArticleByKeyword(keyword, start, cate, amount);
	}
	
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
	public int selectCountTotalForSearch(String search, String cate) {
		return dao.selectCountTotalForSearch(search, cate);
	}
	
	//list-page
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null){
			currentPage = Integer.parseInt(pg);	
		}
		return currentPage;
	}
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		int[] result = {pageGroupStart, pageGroupEnd};
		return result;
	}
	
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	//comment
	public void insertComment(String parent, String content, String uid, String regip) {
		ArticleVO comment = new ArticleVO();
		comment.setParent(parent);
		comment.setContent(content);
		comment.setUid(uid);
		comment.setRegip(regip);
		dao.insertComment(comment, parent);
	}
	
	public List<ArticleVO> selectComments(String parent) {
		return dao.selectComments(parent);
	}
	
	public void deleteComment(String parent) {
		dao.deleteComment(parent);
	}
	
	
}

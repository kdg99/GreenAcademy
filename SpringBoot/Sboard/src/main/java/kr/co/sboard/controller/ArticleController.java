package kr.co.sboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	@GetMapping("list")
	public String list(Model model, String pg) {
		//페이징
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal();
		int lastPageNum = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVO> articles = service.selectArticles(start);
		model.addAttribute("articles", articles);
		model.addAttribute("curretPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
		return "list";
	}
	
	@GetMapping("view")
	public String view(Model model, int no) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);

		return "view";
	}
	
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		//파일조회
		FileVO vo = service.selectFile(fno);
		//파일 다운로드 카운트 증가
		service.updateFileDownload(fno);
		// 파일 다운로드
		ResponseEntity<Resource> resultEntity = service.fileDownload(vo);
		return resultEntity;
	}
	
	@GetMapping("modify")
	public String modify(Model model, int no) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);

		return "modify";
	}
	@PostMapping("modify")
	public String modify(int no, ArticleVO vo) {
		vo.setNo(no);
		service.updateArticle(vo);
		
		return "redirect:/view?no="+no;
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	public String write(ArticleVO vo, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
	@GetMapping("delete")
	public String delete(int no) {
		service.deleteArticle(no);
		return "redirect:/list";
	}
	
	
}

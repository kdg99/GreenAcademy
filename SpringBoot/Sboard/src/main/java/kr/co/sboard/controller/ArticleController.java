package kr.co.sboard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/list")
	public String list(Principal principal, Model model) {
		if(principal != null) {
			List<ArticleVO> articles = service.selectArticles();
			model.addAttribute("articles", articles);
			return "/list";
		}else {
			return "/user/login?success=100";
		}
	}
	
	@GetMapping("/view")
	public String view( Model model, int no) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);
		model.addAttribute("no", no);
		//첨부파일
		FileVO file = null;
		if(article.getFile() > 0) {
			file = service.selectFile(no);
		}
		model.addAttribute("file", file);

		return "/view";
	}
	
	@GetMapping("/modify")
	public String modify(int no, Model model) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);
		//첨부파일
		FileVO file = null;
		if(article.getFile() > 0) {
			file = service.selectFile(no);
		}
		model.addAttribute("file", file);

		return "/modify";
	}
	@PostMapping("/modify")
	public String modify(int no, ArticleVO vo) {
		vo.setNo(no);
		service.updateArticle(vo);
		
		return "redirect:/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(ArticleVO vo, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		service.deleteArticle(no);
		return "/delete";
	}
	
	
}

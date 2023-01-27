package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService service;
    @GetMapping("board/list")
    public String list(Model model, String group, String cate, String pg){
        //페이징
        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);
        int total = service.selectCountTotal(cate);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

        List<ArticleVO> articles = service.selectArticles(start, cate, 10);
        model.addAttribute("articles", articles);
        model.addAttribute("curretPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/list";
    }

    @GetMapping("board/view")
    public String view(Model model, String group, String cate, int no, Principal principal) {
        ArticleVO article = service.selectArticle(no);
        List<ArticleVO> comments = service.selectComments(no, 0, 10);
        service.updateArticleHit(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
        if(principal != null) {
            model.addAttribute("uid", principal.getName());
        }
        return "board/view";
    }

    @GetMapping("board/download")
    public ResponseEntity<Resource> download(int fno) throws IOException {
        //파일조회
        FileVO vo = service.selectFile(fno);
        //파일 다운로드 카운트 증가
        service.updateFileDownload(fno);
        // 파일 다운로드
        ResponseEntity<Resource> resultEntity = service.fileDownload(vo);
        return resultEntity;
    }

    @GetMapping("board/modify")
    public String modify(Model model, String group, String cate, int no) {
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("article", article);
        return "board/modify";
    }

    @PostMapping("board/modify")
    public String modify(int no, String group, String cate, ArticleVO vo) {
        vo.setNo(no);
        service.updateArticle(vo);
        return "redirect:/board/view?group="+group+"&cate="+cate+"&no="+no;
    }

    @GetMapping("board/write")
    public String write(Model model, String group, String cate){
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/write";
    }

    @PostMapping("board/write")
    public String write(ArticleVO vo, HttpServletRequest req, String group, String cate) {
        vo.setRegip(req.getRemoteAddr());
        service.insertArticle(vo);
        return "redirect:/board/list?group="+group+"&cate="+cate;
    }

    @GetMapping("board/delete")
    public String delete(int no, String group, String cate) {
        service.deleteArticle(no);
        return "redirect:/board/list?group="+group+"&cate="+cate;
    }

    //댓글
    @GetMapping("board/addComment")
    public String addComment(HttpServletRequest req, ArticleVO vo, String group){
        vo.setRegip(req.getRemoteAddr());
        service.insertComment(vo);
        return "redirect:/board/view?group="+group+"&cate="+vo.getCate()+"&no="+vo.getParent();
    }
    @GetMapping("board/deleteComment")
    public String deleteComment(int cno, String group, String cate, int no){
        service.deleteArticle(cno);
        service.decreaseArticleComment(no);
        return "redirect:/board/view?group"+group+"&cate="+cate+"&no="+no;
    }

}

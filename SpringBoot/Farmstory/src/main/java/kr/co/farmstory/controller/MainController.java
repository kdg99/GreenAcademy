package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ArticleService service;

    @GetMapping(value = {"", "index"})
    public String index(Model model){
        List<ArticleVO> growList = service.selectArticles(0, "grow", 5);
        List<ArticleVO> schoolList = service.selectArticles(0, "school", 5);
        List<ArticleVO> storyList = service.selectArticles(0, "story", 5);
        List<ArticleVO> noticeList = service.selectArticles(0, "notice", 3);
        List<ArticleVO> qnaList = service.selectArticles(0, "qna", 3);
        List<ArticleVO> faqList = service.selectArticles(0, "faq", 3);
        model.addAttribute("growList", growList);
        model.addAttribute("schoolList", schoolList);
        model.addAttribute("storyList", storyList);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("qnaList", qnaList);
        model.addAttribute("faqList", faqList);
        return "index";
    }

}

package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("user/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("user/register")
    public String register() {
        return "user/register";
    }
    @PostMapping("user/register")
    public String register(UserVO vo, HttpServletRequest req) {
        vo.setRegip(req.getRemoteAddr());
        int result = 200+service.insertUser(vo);
        return "redirect:/user/login?success="+result;
    }

    @GetMapping("user/terms")
    public String terms(Model model) {
        TermsVO terms = service.selectTerms();
        model.addAttribute("terms", terms);

        return "user/terms";
    }

    //기능
    @ResponseBody
    @GetMapping("user/checkUid")
    public Map<String, Integer> checkUid(String uid) {
        int result = service.countUser(uid);
        Map<String, Integer> map = new HashMap<>();
        map.put("result", result);

        return map;
    }

}

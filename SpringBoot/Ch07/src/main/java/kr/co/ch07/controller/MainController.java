package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.entity.User1Entity;
import kr.co.ch07.persistence.User1Repo;

@Controller
public class MainController {

	@Autowired
	private User1Repo repo;
	
	@GetMapping(value= {"/", "/index"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/query1")
	public String query1() {
		User1Entity entity = repo.findUser1EntityByUid("ㅁㄴ");
		System.out.println("query1 결과 : " + entity);
		return "redirect:/";
	}
	
	@GetMapping("/query2")
	public String query2() {
		List<User1Entity> entities = repo.findUser1EntityByName("장보고");
		System.out.println("query2 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query3")
	public String query3() {
		List<User1Entity> entities = repo.findUser1EntityByNameNot("장보고");
		System.out.println("query3 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query4")
	public String query4() {
		List<User1Entity> entities = repo.findUser1EntityByUidAndName("a101", "장보고");
		System.out.println("query4 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query5")
	public String query5() {
		List<User1Entity> entities = repo.findUser1EntityByUidOrName("a101", "장보고");
		System.out.println("query5 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query6")
	public String query6() {
		List<User1Entity> entities = repo.findUser1EntityByAgeGreaterThan(42);
		System.out.println("query6 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query7")
	public String query7() {
		List<User1Entity> entities = repo.findUser1EntityByAgeGreaterThanEqual(42);
		System.out.println("query7 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query8")
	public String query8() {
		List<User1Entity> entities = repo.findUser1EntityByAgeLessThan(42);
		System.out.println("query8 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query9")
	public String query9() {
		List<User1Entity> entities = repo.findUser1EntityByAgeLessThanEqual(42);
		System.out.println("query9 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query10")
	public String query10() {
		List<User1Entity> entities = repo.findUser1EntityByNameLike("%김%");
		System.out.println("query10 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query11")
	public String query11() {
		List<User1Entity> entities = repo.findUser1EntityByNameContains("보");
		System.out.println("query11 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query12")
	public String query12() {
		List<User1Entity> entities = repo.findUser1EntityByNameStartsWith("김");
		System.out.println("query12 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query13")
	public String query13() {
		List<User1Entity> entities = repo.findUser1EntityByNameEndsWith("고");
		System.out.println("query13 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query14")
	public String query14() {
		List<User1Entity> entities = repo.findUser1EntityByAgeOrderByName(42);
		System.out.println("query14 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query15")
	public String query15() {
		List<User1Entity> entities = repo.findUser1EntityByAgeOrderByAgeAsc(42);
		System.out.println("query15 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query16")
	public String query16() {
		List<User1Entity> entities = repo.findUser1EntityByAgeOrderByAgeDesc(42);
		System.out.println("query16 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query17")
	public String query17() {
		List<User1Entity> entities = repo.findUser1EntityByAgeGreaterThanOrderByAgeDesc(30);
		System.out.println("query17 결과 : " + entities);
		return "redirect:/";
	}
	
	@GetMapping("/query18")
	public String query18() {
		int count = repo.countUser1EntityByUid("a101");
		System.out.println("query18 결과 : " + count);
		return "redirect:/";
	}
	
	@GetMapping("/query19")
	public String query19() {
		int count = repo.countUser1EntityByName("김동근");
		System.out.println("query19 결과 : " + count);
		return "redirect:/";
	}
	
	@GetMapping("/query20")
	public String query20() {
		List<User1Entity> entities = repo.selectUserUnderAge30();
		System.out.println("query20 결과 : " + entities);
		return "redirect:/";
	}
	
	
}

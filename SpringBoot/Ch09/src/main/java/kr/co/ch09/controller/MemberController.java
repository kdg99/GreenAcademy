package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch09.service.MemberService;
import kr.co.ch09.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@ResponseBody //json 출력 리턴할 때
	@GetMapping("/member")
	public List<MemberVO> list() {
		List<MemberVO> users = service.selectMembers();
		return users;
	}
	
	//주소 파라미터
	@ResponseBody
	@GetMapping("/member/{uid}")
	public MemberVO list(@PathVariable("uid") String uid) {
		return service.selectMember(uid);
	}
	
	@ResponseBody
	@PostMapping("/member")
	public List<MemberVO> register(MemberVO vo) {
		service.insertMember(vo);
		return service.selectMembers();
	}
	
	@ResponseBody
	@PutMapping("/member")
	public List<MemberVO> modify(MemberVO vo) {
		service.updateMember(vo);
		return service.selectMembers();
	}
	
	@ResponseBody
	@DeleteMapping("/member/{uid}")
	public List<MemberVO> delete(@PathVariable("uid") String uid) {
		service.deleteMember(uid);
		return service.selectMembers();
	}
}

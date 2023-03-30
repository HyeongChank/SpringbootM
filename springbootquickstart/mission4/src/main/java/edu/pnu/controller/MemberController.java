package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	public MemberService ms = new MemberService();
	public MemberController() {
		
	}
	@GetMapping("/memberall")
	public List<MemberVO> getMembers(){
		return ms.getMembers();
	}
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return ms.getMember(id);
	}
}

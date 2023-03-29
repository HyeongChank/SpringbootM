package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MysqlController {
	
	static MemberService ms = new MemberService();
	static List<Member> ls = new ArrayList<>();
	public MysqlController() {
		
	}
	@GetMapping("/selectMember")
	public List<Member> selectMember() {
		System.out.println("controller 페이지");
		return ms.selectMember();
	}
}

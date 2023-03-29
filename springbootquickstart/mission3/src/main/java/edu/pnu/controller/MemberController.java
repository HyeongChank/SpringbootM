package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;


@RestController
public class MemberController{
	public MemberVO mv = new MemberVO();
	static List<MemberVO> ls = new ArrayList<>();
	public MemberService ms = new MemberService();
	public MemberDaoH2Impl md = new MemberDaoH2Impl();

	public MemberController() {
		
	}

	@GetMapping("/memberall")
	public List<MemberVO> getmembers(){
		
		return ms.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getmember(@PathVariable Integer id) {
		
		return ms.getMember(id);
	}
	
	@GetMapping("/member/{pass}/{name}")
	public MemberVO addmember(@PathVariable String pass, @PathVariable String name) {
		
		return ms.addMember(pass, name);
	}
	@GetMapping("/memberD/{id}")
	public MemberVO deletemember(@PathVariable Integer id) {
		
		return ms.deleteMember(id);
	}

	
}

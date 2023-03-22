package edu.pnu.controller;

import java.util.List;
import java.util.ArrayList;
import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberController {

	private static MemberService memberservice = new MemberService();
	
	@GetMapping("/addMember")
	public List<Member> addMember() {
		System.out.println("addMember");
		return memberservice.addMember();
	}
	//get 외에는 postman으로 실행해야 함
	@PostMapping("/addMemberp")
	public List<Member> addMemberp() {
		System.out.println("Post addMember");
		return memberservice.addMember();
	}
	
	@GetMapping("/getMembers")
	public List<Member> getMembers(){
		System.out.println("getMembers");
		return memberservice.getMembers();
	}
	
	@GetMapping("/removeMember/{id}")
	public Member removeMember(@PathVariable Integer id){
		System.out.println("removeMember");	
		return memberservice.removeMember(id);
	}
	
	@GetMapping("/searchMember/{id}")
	public Member searchMember(@PathVariable Integer id) {
		System.out.println("searchMember");	
		return memberservice.searchMember(id);
	}
	//update 는 setname, setpass로 하면됨
	
	@GetMapping("/updateMember/{id}")
	public Member updateMember(@PathVariable Integer id) {
		System.out.println("updateMember");
		//수정
		return memberservice.updateMember(id);
	}
}

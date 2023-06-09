package edu.pnu.controller;

import java.util.List;
import java.util.ArrayList;
import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

import java.sql.Date;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class MemberController {

	private static MemberService memberservice = new MemberService();
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController(MemberService memberService) {
		log.info("생성자 호출");
		log.error("error");
		log.warn("warn");
		log.debug("debug");
		log.trace("trace");
	}
	
	
	@GetMapping("/addMember/{pass}/{name}")
	public Member addMember(@PathVariable String pass, @PathVariable String name) {
		System.out.println("addMember");
		return memberservice.addMember(pass, name);
	}
	
	@GetMapping("/Member")
	public Member readMember(){
		System.out.println("readmember");
		return memberservice.readMember();
	}
	@GetMapping("/deleteMember/{pass}")
	public Member deleteMember(@PathVariable String pass) {
		System.out.println("deletemember");
		return memberservice.deleteMember(pass);
	}
	@GetMapping("/updateMember/{pass}/{name}")
	public Member updateMember(@PathVariable String pass, @PathVariable String name) {
		System.out.println("updatemember");
		return memberservice.updateMember(pass, name);
	}
	
	@GetMapping("/showallMember")
	public List<Member> showallMember() {
		System.out.println("showallMember");
		return memberservice.showallMember();
	}
	
	
}

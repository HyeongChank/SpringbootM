package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	//Autowired로 
	@Autowired
	public MemberService ms ;
//	public MemberService ms = new MemberService();
	
//	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	
	public MemberController() {
		
	}
//	public void setMemberService(MemberService ms) {
//		log.info("seter가 호출됨");
//		this.ms = ms;
//	}
	@GetMapping("/memberall")
	public List<MemberVO> getMembers(){
		return ms.getMembers();
	}
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return ms.getMember(id);
	}
	

}

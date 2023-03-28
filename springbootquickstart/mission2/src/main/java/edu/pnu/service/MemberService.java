package edu.pnu.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Date;
import edu.pnu.domain.Member;
import edu.pnu.domain.MemberDAO;


@Service
public class MemberService {
	
	public MemberDAO memberdao = new MemberDAO();
	
	public Member addMember(String pass, String name) {
		//java.util.Date 사용		
		memberdao.getMember(new Member(pass,name));
		
		return null;
	}
	public Member readMember(){
		
		return memberdao.readMember();
	}
	public Member deleteMember(String pass) {
		memberdao.deleteMember(pass);
		return null;
	}
	public Member updateMember(String pass, String name) {
		memberdao.updateMember(pass, name);
		return null;
	}
	public List<Member> showallMember() {

		return memberdao.showallMember();
	}
	
}

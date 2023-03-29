package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.MemberDAO;
@Service
public class MemberService {
	static Member mb = new Member();
	static MemberDAO md = new MemberDAO();
	static List<Member> ls = new ArrayList<>();

	public MemberService() {
		
	}
	public List<Member> selectMember() {
		System.out.println("service 페이지");
		return md.selectMember();
	}
}

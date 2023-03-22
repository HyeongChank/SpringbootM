package edu.pnu.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Date;
import edu.pnu.domain.Member;


@Service
public class MemberService {
	private static List<Member> ls = new ArrayList<>();

	private static Member mb = new Member();
	public MemberService() {
		for(int i=1; i<20;i++) {
//regidate에 new Date() 를 받은 거 사용
			ls.add(new Member(i,"이름","1234"));

		}		
	}
	public List<Member> getMembers(){
		return ls;
	}
	public List<Member> addMember() {
		//java.util.Date 사용		
		ls.add(new Member(500,"khc","1234", new Date()));
		
		return ls;
	}

	public Member searchMember(int id){
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i).getId()==id) {
				return ls.get(i);
			}
		}
		for(Member m : ls) {
			if(m.getId()==id) {
				return ls.get(id);
			}
		}
		return null;
	}
	public Member removeMember(int id) {
		for(int i=0; i<ls.size();i++) {
			if(ls.get(i).getId()==id) {
				ls.remove(i);
				System.out.println("id " + i + "번 삭제");
			}
		}
		return null;
	}
	public Member updateMember(int id) {
		for(Member m : ls) {
			if(m.getId()==id) {
				m.setName("updatename");
				m.setPass("updatePass                               ");
				return m;
			}
		}
		return null; 
	}
}

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
		String [] list = {"jack","kal","khc","cowor"};
		int i=1;
		while(true) {
//regidate에 new Date() 를 받은 거 사용
			for(int j=0; j<list.length;j++) {
				ls.add(new Member(i,list[j],"1234"));
				i++;
			}
			System.out.println(ls);
			break;
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
	public Member deleteMember(int id) {
		for(int i=0; i<ls.size();i++) {
			if(ls.get(i).getId()==id) {
				ls.remove(i);
				System.out.println("id " + id + "번 삭제");
				break;
			}
		}
		System.out.println("id " + id + "번 없음");
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

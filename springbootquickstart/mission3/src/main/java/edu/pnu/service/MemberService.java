package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberDao md;
//	MemberDaoH2Impl md ;
//	MemberDaoListImpl md;
//	MemberVO md;
	
		
	public MemberService() {
//		md = new MemberDaoH2Impl();
		md = new MemberDaoListImpl();
	}
	public List<MemberVO> getMembers() {
		// TODO Auto-generated method stub
		return md.getMembers();
	}

	public MemberVO getMember(Integer id) {
		// TODO Auto-generated method stub
		return md.getMember(id);
	}

	public MemberVO getMemberjson(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}
	public MemberVO deleteMember(Integer id) {
		// TODO Auto-generated method stub
		return md.deleteMember(id);
	}
	public MemberVO addMember(String pass, String name) {
		// TODO Auto-generated method stub
		return md.addMember(pass, name);
	}

	
}

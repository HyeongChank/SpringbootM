package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {

	private List<MemberVO> list;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		String str = "가나다라";
		String [] strlist = str.split("");
		
		for (int i = 1 ; i <= 5 ; i++) {
			list.add(new MemberVO(i, "1234", "ek"+i, new Date()));
		}
	}
	@Override
	public List<MemberVO> getMembers() {
		return list;
	}
	@Override
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}
	@Override
	public MemberVO addMember(String pass, String name) {
		return null;
		
	}
	@Override
	public MemberVO deleteMember(Integer id) {
		return null;
	}



}

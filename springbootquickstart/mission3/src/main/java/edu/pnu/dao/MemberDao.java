package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDao {

	MemberVO getMember(Integer id);
	
	List<MemberVO> getMembers();

	MemberVO addMember(String pass, String name);
	
	MemberVO deleteMember(Integer id);
	


}

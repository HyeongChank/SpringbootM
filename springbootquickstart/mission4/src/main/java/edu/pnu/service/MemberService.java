package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;
import edu.pnu.dao.MemberDao;
import edu.pnu.dao.logDao;


public class MemberService {
	public MemberDao md = new MemberDao();
	public logDao ld;
	public List<MemberVO> getMembers() {

		return md.getMembers();
	}
	public MemberVO getMember(Integer id) {

		return md.getMember(id);
	}


}

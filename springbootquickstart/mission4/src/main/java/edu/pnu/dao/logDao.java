package edu.pnu.dao;

import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface logDao {

//	Map<String, MemberVO> errMsg(String[] list, Map<String, MemberVO> m);
//	MemberVO sucMsg(String str, MemberVO mv);
	
	Map<String, MemberVO> msg(String[] list, Map<String, MemberVO> m);
	MemberVO msg(String str, MemberVO mv);
}
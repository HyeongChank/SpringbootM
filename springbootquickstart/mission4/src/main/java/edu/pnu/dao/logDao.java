package edu.pnu.dao;

import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface logDao {

	Map<String, MemberVO> msg(String[] list, Map<String, MemberVO> m);
	MemberVO msg(String str, MemberVO mv);
}
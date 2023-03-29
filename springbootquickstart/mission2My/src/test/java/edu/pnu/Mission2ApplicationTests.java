package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.MemberDAO;
import edu.pnu.domain.Member;

@SpringBootTest
class Mission2ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("이것은 테스트");
	}

	@Test
	void testMemberDAO() {
		System.out.println("이것은 dao테스트");
		MemberDAO memberdao = new MemberDAO();
		List<Member> list = memberdao.showallMember();
		for(Member m : list) {
			System.out.println(m);
		}
	}
}
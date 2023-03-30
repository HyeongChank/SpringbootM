//package edu.pnu.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import edu.pnu.domain.MemberVO;
//
//public class SuccesslogDao implements logDao {
//	public Connection con;
//	//statement, preparedstatement 차이 : psmt는 쿼리 파이딩을 위해 '?' 사용 가능,
//	// SQL Injection 공격으로부터 보호 가능 -> psmt쓰면 안전 효율
//	
//	public Statement stmt;
//	public PreparedStatement psmt;
//	public ResultSet rs;
//	public SuccesslogDao() {
//		try {
//			Class.forName("org.h2.Driver");
//			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
//			System.out.println("드라이버 연결 성공");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}	
//	@Override
//	public MemberVO sucMsg(String qu, MemberVO mv) {
//		// TODO Auto-generated method stub
//		try {
//			Class.forName("org.h2.Driver");
//			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
//			System.out.println("드라이버 연결 성공");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		String method = mv.getName();
//		String string = qu;
//		boolean success = true;
//		int result =0;
//		String query = "insert into dblog(method, string, success) values(?, ?, ?)";
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, method);
//			psmt.setString(2, string);
//			psmt.setBoolean(3, success);
//			result = psmt.executeUpdate();
//			System.out.println("dblog 등록 성공");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//	}
//	@Override
//	public Map<String, MemberVO> errMsg(String[] list, Map<String, MemberVO> m) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}

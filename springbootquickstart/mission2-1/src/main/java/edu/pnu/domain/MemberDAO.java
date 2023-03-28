package edu.pnu.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	static List<Member> ls = new ArrayList<>();
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "jsk281988";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("db 연결 성공");
		}
		catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	public List<Member> selectMember(){
		
		String query = "select * from member";
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
		// Member mb = new Member() 객체를 while 문 밖에 만들면 객체 하나만 반복되서 나옴
		// 이유는 생성자 주소값을 저장하는 거기 때문
			while(rs.next()) {
				Member mb = new Member();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setRegidate(rs.getDate("regidate"));
				System.out.print(rs.getString("id") + "  ");
				ls.add(mb);
			}
			System.out.println();
			System.out.println(ls);
		}
		catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return ls;
	}
}

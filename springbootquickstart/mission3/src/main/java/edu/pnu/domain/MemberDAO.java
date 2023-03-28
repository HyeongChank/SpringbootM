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

package edu.pnu.domain;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAO {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	public List<Member> ls = new ArrayList<>();
	public MemberDAO() {
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String user = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB 연결 성공(기본 생성자)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Member> showallMember() {
		
		
		String query = "select * from member";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.setId(rs.getInt("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setRegidate(rs.getDate("regidate"));

				ls.add(mb);
			}
		}
		catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		System.out.println(rs);
		return ls;
	}
	
	public Member readMember() {

		Member mb = new Member();
		String query = "select * from member";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mb.setPass(rs.getString("id"));
				mb.setName(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setName(rs.getString("regidate"));
			}
		}
		catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		return mb;
	}

	public int deleteMember(String pass) {
		int result = 0;
		String query = "delete from member where pass= ?";
		try {

			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		return result;
	}

	public int getMember(Member mb) {
		String query = "insert into member("
					+ " pass, name)"
					+ " values(" + " ?,?)";
		ls.add(new Member(mb.getPass(),mb.getName()));
		int result = 0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, mb.getPass());
			psmt.setString(2, mb.getName());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(String pass, String name) {
		int result = 0;
		String query = "update member set name = ? where pass= ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, pass);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		return result;
	}
	

}

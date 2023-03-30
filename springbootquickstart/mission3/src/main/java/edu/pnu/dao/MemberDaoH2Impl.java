package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	public Connection con;
	//statement, preparedstatement 차이 : psmt는 쿼리 파이딩을 위해 '?' 사용 가능,
	// SQL Injection 공격으로부터 보호 가능 -> psmt쓰면 안전 효율
	
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	public List<MemberVO> ls = new ArrayList<>();
	public MemberVO mv = new MemberVO();
	
	public MemberDaoH2Impl() {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
            System.out.println("driver 연결 성공");
        }
        catch (Exception e) {            
            e.printStackTrace();
            String errMsg = e.getMessage();
        }
	}
	
	@Override
	public List<MemberVO> getMembers() {
		String query = "select * from member order by id asc";
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next() ) {
				MemberVO mv = new MemberVO();
				mv.setId(rs.getInt("id"));
				mv.setPass(rs.getString("pass"));
				mv.setName(rs.getString("name"));
				mv.setRegidate(rs.getDate("regidate"));
				ls.add(mv);
			}
			System.out.println(ls);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ls;
	}

	@Override
	public MemberVO getMember(Integer id) {
		String query = "select * from member where id = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mv.setId(rs.getInt("id"));
				mv.setPass(rs.getString("pass"));
				mv.setName(rs.getString("name"));
				mv.setRegidate(rs.getDate("regidate"));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	@Override
	public MemberVO addMember(String pass, String name) {
		// TODO Auto-generated method stub
		String query = "insert into member(pass, name) values(?,?)";
		int result =0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			psmt.setString(2, name);
			result = psmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public MemberVO deleteMember(Integer id) {
		String query = "delete from member where id=?";
		int result =0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


	


}

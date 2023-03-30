package edu.pnu.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import edu.pnu.dao.LogDBRegit;
import edu.pnu.dao.logDao;
public class MemberDao {
	public Connection con;
	//statement, preparedstatement 차이 : psmt는 쿼리 파이딩을 위해 '?' 사용 가능,
	// SQL Injection 공격으로부터 보호 가능 -> psmt쓰면 안전 효율
	
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	public List<MemberVO> ls = new ArrayList<>();
	public Map<String, MemberVO> m = new HashMap<>();
	public Map<String [], MemberVO> mm= new HashMap<>();
	public MemberDao() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("드라이버 연결 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<MemberVO> getMembers(){
		String query = "select * from member";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setId(rs.getInt("id"));
				mv.setString(rs.getString("pass"));
				mv.setString(rs.getString("name"));
				mv.setDate(rs.getDate("regidate"));
				ls.add(mv);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
		
	}
	public MemberVO getMember(Integer id) {
		MemberService ms = new MemberService();
		String query = "select * from members where id =?";
		MemberVO mv = new MemberVO();
		logDao ed = new LogDBRegit();
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				mv.setId(rs.getInt("id"));
				mv.setPass(rs.getString("pass"));
				mv.setName(rs.getString("name"));
				mv.setDate(rs.getDate("regidate"));
				System.out.println("id : " + rs.getInt("id") + "pass : " + rs.getString("pass") + "name : " + rs.getString("name") + "regidate : " + rs.getDate("regidate"));
			}
			System.out.println("성공중");
			ed.msg(query, mv);
		}
		catch(Exception e) {
			String errMsg = e.getMessage();
			System.out.println("실패");
			String [] list = {query, errMsg};
			System.out.println("오류중");
			m.put(query, mv);
			ed.msg(list, m);
		}
		return null;
	}
	
	
	
	

	
}

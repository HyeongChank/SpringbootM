package edu.pnu.domain;


import java.util.Date;
public class Member {
	private int id;
	private String name;
	private String pass;
	private Date regidate = new Date();
	
	
	public Member(int id, String name, String pass, Date regidate) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.regidate = regidate;
	}
	public Member(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public Member() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pass=" + pass + ", regidate=" + regidate + "]";
	}

	
	
	
}

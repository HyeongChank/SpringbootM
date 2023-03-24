package edu.pnu.domain;


import java.util.Date;
public class Member {

	private String pass;
	private String name;
	public Member() {
		
	}
	public Member(String pass, String name) {
		super();
		
		this.pass = pass;
		this.name = name;
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
	@Override
	public String toString() {
		return "Member [name=" + name + ", pass=" + pass + "]";
	}
	
	

	
	
}

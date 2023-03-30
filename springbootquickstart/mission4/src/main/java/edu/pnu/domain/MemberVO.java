package edu.pnu.domain;

import java.util.Date;

public class MemberVO {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
	private String method;
	private String string;
	private boolean success;
	private Date date;
	public MemberVO() {
		
	}
	public MemberVO(int id, String pass, String name, Date regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}
	public MemberVO(int id, String method, String string, boolean success, Date date) {
		super();
		this.id = id;
		this.method = method;
		this.string = string;
		this.success = success;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}
	
	
}

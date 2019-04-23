package modal;

import java.io.Serializable;

public class user implements Serializable{
	private static final long serialVersionUID=12345678;
	private String uname;
	private String uaccount;
	private int password;
	//用户角色0代表普通员工，1代表店长
	private int uleavl;
	public user(String uname, String uaccount, int password, int uleavl) {
		super();
		this.uname = uname;
		this.uaccount = uaccount;
		this.password = password;
		this.uleavl = uleavl;
	}
	public user() {
		super();
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getUleavl() {
		return uleavl;
	}
	public void setUleavl(int uleavl) {
		this.uleavl = uleavl;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.uname+"\t"+this.uaccount+"\t"+this.password+"\t"+this.uleavl;
	}
	
	
}

package modal;

import java.io.Serializable;
import java.sql.Date;

public class vip implements Serializable{
	private static final long serialVersionUID=1234567;
	//卡号
	private int memnumber;
	//姓名
	private String memname;
	//会员手机号
	private String memphone;
	//余额
	private double membalance;
	//充值日期
	private Date memdate;
	//卡状态
	private int memmode;
	
	public vip(int memnumber, String memname, String memphone, double membalance, Date memdate, int memmode) {
		super();
		this.memnumber = memnumber;
		this.memname = memname;
		this.memphone = memphone;
		this.membalance = membalance;
		this.memdate = memdate;
		this.memmode = memmode;
	}
	
	public vip(int memnumber) {
		super();
		this.memnumber = memnumber;
	}

	public vip() {
		super();
	}
	public int getMemnumber() {
		return memnumber;
	}
	public void setMemnumber(int memnumber) {
		this.memnumber = memnumber;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	
	public String getMemphone() {
		return memphone;
	}
	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}
	public double getMembalance() {
		return membalance;
	}
	public void setMembalance(double membalance) {
		this.membalance = membalance;
	}
	public Date getMemdate() {
		return memdate;
	}
	public void setMemdate(Date memdate) {
		this.memdate = memdate;
	}
	public int getMemmode() {
		return memmode;
	}
	public void setMemmode(int memmode) {
		this.memmode = memmode;
	}
	
	
}

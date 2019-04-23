package modal;

import java.io.Serializable;

public class bill implements Serializable{//账单
	private static final long serialVersionUID=123456;
	//账单编号
	private String bilnumber;
	//消费日期
	private String bildate;
	private menu m;
	public bill(String bilnumber, String bildate) {
		super();
		this.bilnumber = bilnumber;
		this.bildate = bildate;
	}
	
	public bill(String bilnumber, String bildate, double bilcost, menu m) {
		super();
		this.bilnumber = bilnumber;
		this.bildate = bildate;
		this.m = m;
	}

	public bill() {
		super();
	}
	public String getBilnumber() {
		return bilnumber;
	}
	public void setBilnumber(String bilnumber) {
		this.bilnumber = bilnumber;
	}
	public String getBildate() {
		return bildate;
	}
	public void setBildate(String bildate) {
		this.bildate = bildate;
	}
	
}

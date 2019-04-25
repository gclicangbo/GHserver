package modal;

import java.io.Serializable;

public class bill implements Serializable{//账单
	private static final long serialVersionUID=123456;
	//账单编号
	private String bilnumber;
	//消费日期
	private String bildate;
	//消费总额
	private double bilcost;
	private menu m;
	private vip v;
	public bill(String bilnumber, double bilcost,String bildate) {
		super();
		this.bilnumber = bilnumber;
		this.bilcost=bilcost;
		this.bildate = bildate;
		
	}
	
	public bill(String bilnumber, String bildate, double bilcost, menu m) {
		super();
		this.bilnumber = bilnumber;
		this.bildate = bildate;
		this.m = m;
	}

	public bill(String bildate, menu m, vip v) {
		super();
		this.bildate = bildate;
		this.m = m;
		this.v = v;
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

	public menu getM() {
		return m;
	}

	public void setM(menu m) {
		this.m = m;
	}
	

	public vip getV() {
		return v;
	}

	public void setV(vip v) {
		this.v = v;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.m.getMenuenumber()+"\t"+this.m.getNum()+this.m.getNum()*this.m.getPrice();
	}
	
	
	
}

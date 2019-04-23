package service;

import java.sql.Date;
import java.util.List;

import biz.billBiz;
import biz.menuBiz;
import biz.userBiz;
import biz.vipBiz;
import bizImpl.billBizImpl;
import bizImpl.menuBizImpl;
import bizImpl.userBizImpl;
import bizImpl.vipBizImpl;
import modal.bill;
import modal.menu;
import modal.user;
import modal.vip;

public class TotalServiceImpl implements TotalService {
	private billBiz bbz;
	private menuBiz men;
	private userBiz ubz;
	private vipBiz vbz;
	public TotalServiceImpl() {
		super();
		this.bbz = new billBizImpl();
		this.men = new menuBizImpl();
		this.ubz = new userBizImpl();
		this.vbz = new vipBizImpl();
	}
	@Override
	public String verifyuser(String uname, String uaccount, int upassword,int uleavl) {
		// TODO Auto-generated method stub
		return this.ubz.verifyuser(uname, uaccount, upassword,uleavl);
	}
	@Override
	public String adduser(user u) {
		// TODO Auto-generated method stub
		return this.ubz.adduser(u);
	}
	@Override
	public String deleteuser(String uid) {
		// TODO Auto-generated method stub
		return this.ubz.deleteuser(uid);
	}
	@Override
	public List<user> selectAll() {
		// TODO Auto-generated method stub
		return this.ubz.selectAll();
	}
	@Override
	public user selectById(String uid) {
		// TODO Auto-generated method stub
		return this.ubz.selectById(uid);
	}
	
	
	@Override
	public List<menu> selectAlltwo() {
		// TODO Auto-generated method stub
		return this.men.selectAll();
	}
	@Override
	public String addFood(menu m) {
		// TODO Auto-generated method stub
		return this.men.addFood(m);
	}
	@Override
	public String deleteFood(String fn) {
		// TODO Auto-generated method stub
		return this.men.deleteFood(fn);
	}
	@Override
	public String updateFood(String dishes, String newdishes) {
		// TODO Auto-generated method stub
		return this.men.updateFood(dishes, newdishes);
	}
	@Override
	public String updateFood(String dishes, double price) {
		// TODO Auto-generated method stub
		return this.men.updateFood(dishes, price);
	}
	
	
	@Override
	public double selectBsame(Date d) {
		// TODO Auto-generated method stub
		return this.bbz.selectBsame(d);
	}
	@Override
	public List<bill> selectBill() {
		// TODO Auto-generated method stub
		return this.bbz.selectBill();
	}
	@Override
	public List<bill> print(String billid) {
		// TODO Auto-generated method stub
		return this.bbz.print(billid);
	}
	@Override
	public double amountall(String bilnumber) {
		// TODO Auto-generated method stub
		return this.bbz.amountall(bilnumber);
	}
	@Override
	public String adddishes(String bilnumber, int memnumber, String dishes, double memamount) {
		// TODO Auto-generated method stub
		return this.bbz.adddishes(bilnumber, memnumber, dishes, memamount);
	}
	
	
	@Override
	public String addvip(vip v) {
		// TODO Auto-generated method stub
		return this.vbz.addvip(v);
	}
	@Override
	public List<vip> selectAllthree() {
		// TODO Auto-generated method stub
		return this.vbz.selectAll();
	}
	@Override
	public vip selectByphone(String phonum) {
		// TODO Auto-generated method stub
		return this.vbz.selectById(phonum);
	}
	@Override
	public String Freezacc(String memname, String memphone) {
		// TODO Auto-generated method stub
		return this.vbz.Freezacc(memname, memphone);
	}
	@Override
	public String deduct(int memnumber, double factprcie) {
		// TODO Auto-generated method stub
		return this.vbz.deduct(memnumber, factprcie);
	}
	
	
	
}

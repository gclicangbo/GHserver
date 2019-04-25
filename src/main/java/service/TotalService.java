package service;

import java.sql.Date;
import java.util.List;

import modal.bill;
import modal.menu;
import modal.user;
import modal.vip;

public interface TotalService {
	//验证登录信息
	public String verifyuser(String uname,String uaccount,int upassword,int uleavl);
	//添加新用户
	public String adduser(user u);
	//返回删除用户信息
	public String deleteuser(String uid);
	//返回用户集合
	public List<user> selectAll();
	//根据用户帐号查看用户信息
	public user selectById(String uid);
	
	//查看菜单
	public List<menu> selectAlltwo();
	//添加菜名
	public String addFood(menu m);
	//删除菜名
	public String deleteFood(String fn);
	//修改菜名
	public String updateFood(String dishes,String newdishes);
	//修改菜价
	public String updateFood(String dishes,double price);
	
	//查看当日账单
	public double selectBsame(Date d);
	//查看所有账单
	public List<bill> selectBill();
	//打印小票
	public List<bill> print(String billid);
	//结算最新用户的账单
	public double amountall(String bilnumber);
	//将点菜内容放进表中
	public String adddishes(String bilnumber,int memnumber,String dishes,double memamount);
	//插入表中
	public String addBills(String bilnumber,Date d,double bilcost);
	//查看所有会员用餐情况
	public List<bill> print();
	
	//添加会员(办卡)
	public String addvip(vip v);
	//查看所有会员信息
	public List<vip> selectAllthree();
	//根据手机号查询会员信息
	public vip selectByphone(String phonum);
	//冻结账号
	public String Freezacc(String memname, String memphone);
	//解封帐号
	public String jf(String memname,String memphone);
	//返回扣值信息
	public String deduct(String phonum,double factprcie);
	//返回充值信息
	public String increase(String phonum,double money,Date d);
	//返回删卡信息
	public String deletecard(String phonum);
}

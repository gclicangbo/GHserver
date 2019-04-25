package biz;

import java.sql.Date;
import java.util.List;

import modal.bill;

public interface billBiz {
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
}

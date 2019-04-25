package biz;

import java.sql.Date;
import java.util.List;

import modal.vip;

public interface vipBiz {
	    //添加会员(办卡)
		public String addvip(vip v);
		//查看所有会员信息
		public List<vip> selectAll();
		//根据手机号查询会员信息
		public vip selectByphone(String phonum);
		//冻结账号
		public String Freezacc(String memname, String memphone);
		//解封帐号
		public String jf(String memname,String memphone);
		//返回扣值信息
		public String deduct(String phonum,double factprcie);
		//返回充值金额
		public String increase(String phonum,double money,Date d);
		//返回删除卡号信息
		public String deletecard(String phonum);
}

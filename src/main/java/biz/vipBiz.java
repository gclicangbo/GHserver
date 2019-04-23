package biz;

import java.util.List;

import modal.vip;

public interface vipBiz {
	    //添加会员(办卡)
		public String addvip(vip v);
		//查看所有会员信息
		public List<vip> selectAll();
		//根据手机号查询会员信息
		public vip selectById(String phonum);
		//冻结账号
		public String Freezacc(String memname, String memphone);
		//返回扣值信息
		public String deduct(int memnumber,double factprcie);
}

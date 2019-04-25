package dao;

import java.sql.Date;
import java.util.List;

import modal.vip;

public interface vipDao {
	//添加会员(办卡)
	public boolean addvip(vip v);
	//删除会员卡
	public boolean deletecard(String phonum);
	//查看所有会员信息
	public List<vip> selectAll();
	//根据手机号查询会员信息
	public vip selectByphone(String phonum);
	//冻结账号
	public boolean Freezacc(String memname,String memphone);
	//解封帐号
	public boolean jf(String memname,String memphone);
	//扣除会员的实际消费金额
	public boolean deduct(String phonum,double factprcie);
	//充值金额
	public boolean increase(String phonum,double money,Date d);
}

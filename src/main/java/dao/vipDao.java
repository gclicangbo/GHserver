package dao;

import java.util.List;

import modal.vip;

public interface vipDao {
	//添加会员(办卡)
	public boolean addvip(vip v);
	//查看所有会员信息
	public List<vip> selectAll();
	//根据手机号查询会员信息
	public vip selectById(String phonum);
	//冻结账号
	public boolean Freezacc(String memname,String memphone);
	//扣除会员的实际消费金额
	public boolean deduct(int memnumber,double factprcie);
}

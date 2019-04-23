package dao;

import java.util.List;

import modal.user;

public interface userDao {
	//登录验证姓名，帐号，密码
	public boolean verifyuser(String uname,String uaccount,int upassword,int uleavl);
	//添加用户
	public boolean adduser(user u);
	//删除用户
	public boolean deleteuser(String uaccount);
	//查看所有用户
	public List<user> selectAll();
	//根据用户id查看用户信息
	public user selectById(String uid);
}

package biz;

import java.util.List;

import modal.user;

public interface userBiz {
		//返回验证信息
		public String verifyuser(String uname,String uaccount,int upassword,int uleavl);
		//返回添加用户信息
		public String adduser(user u);
		//返回添加用户信息
		public String deleteuser(String uid);
		//返回用户集合
		public List<user> selectAll();
		//根据用户帐号查看用户信息
		public user selectById(String uid);
}

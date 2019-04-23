package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.userDao;
import modal.user;
import util.DBUtil;

public class userImpl implements userDao{
	private DBUtil db;
	//登录验证
	public boolean verifyuser(String uname, String uaccount, int upassword,int uleavl) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		try {
			String sql="select * from UserTable where uname=?and uaccount=? and upassword=?";
			ResultSet rs = this.db.query(sql,uname,uaccount,upassword);
			if(rs.next()&&uleavl==rs.getInt("uleavl")){
			    return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}finally {
			this.db.closed();
		}
		return false;
	}
	//添加用户
	public boolean adduser(user u) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into UserTable values(?,?,?,?)";
		try {
			int i = this.db.update(sql,u.getUname(),u.getUaccount(),u.getPassword(),u.getUleavl() );
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//删除用户根据用户的帐号删除
	public boolean deleteuser(String uaccount) {
		// TODO Auto-generated method stub
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="delete from UserTable where uaccount=?";
		try {
			return this.db.update(sql,uaccount)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//查看所有用户
	public List<user> selectAll() {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from UserTable";
		List<user> list=new ArrayList<user>();
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new user(rs.getString("uname"), rs.getString("uaccount"), rs.getInt("upassword"), rs.getInt("uleavl")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据帐号查询
	public user selectById(String uaccount) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from UserTable where uaccount=?";
		try {
			ResultSet rs = this.db.query(sql,uaccount);
			if(rs.next()){
				return new user(rs.getString("uname"), rs.getString("uaccount"),rs.getInt("upassword") , rs.getInt("uleavl"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	

}

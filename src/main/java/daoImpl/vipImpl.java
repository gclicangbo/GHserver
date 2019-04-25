package daoImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.vipDao;
import modal.user;
import modal.vip;
import util.DBUtil;

public class vipImpl implements vipDao{
	private DBUtil db;
	//添加会员(办卡)
	public boolean addvip(vip v) {
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into MemberTable values(?,?,?,?,?,?)";
		try {
			int i = this.db.update(sql,v.getMemnumber(),v.getMemname(),v.getMemphone(),v.getMembalance(),v.getMemdate(),v.getMemmode());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//查看所有会员信息
	public List<vip> selectAll() {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from MemberTable";
		List<vip> list=new ArrayList<vip>();
		try {
		ResultSet rs = this.db.query(sql);
			while(rs.next()){
			list.add(new vip(rs.getInt("memnumber"), rs.getString("memname"), rs.getString("memphone"), rs.getDouble("membalance"),rs.getDate("memdate"),rs.getInt("memmode")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	public vip selectByphone(String phonum) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from MemberTable where memphone=?";
		try {
			ResultSet rs = this.db.query(sql,phonum);
			if(rs.next()){
				return new vip(rs.getInt("memnumber"), rs.getString("memname"), rs.getString("memphone"), rs.getDouble("membalance"),rs.getDate("memdate"),rs.getInt("memmode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据姓名手机号冻结或者解封
	@Override
	public boolean Freezacc(String memname, String memphone) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from MemberTable where memname=?and memphone=?";
		try {
			ResultSet rs = this.db.query(sql,memname,memphone);
			if(rs.next()){
				String sql2="update MemberTable set memmode=0";
				int i = this.db.update(sql2);
				return i>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}

	@Override
	public boolean jf(String memname, String memphone) {
		// 实例化DBUtil()
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from MemberTable where memname=?and memphone=?";
		try {
			ResultSet rs = this.db.query(sql, memname, memphone);
			if (rs.next()) {
				String sql2 = "update MemberTable set memmode=1";
				int i = this.db.update(sql2);
				return i > 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}
	//扣除金额
	@Override
	public boolean deduct(String phonum,double factprcie) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select membalance from MemberTable where memphone=?";
		//创建临时变量存储余额
		double a;
		try {
			ResultSet rs = this.db.query(sql, phonum);
			if(rs.next()){
				if(rs.getDouble("membalance")>factprcie){
					a=rs.getDouble("membalance")-factprcie;
					String sql2="update MemberTable set membalance=? where memphone=?";
					int i = this.db.update(sql2,a,phonum);
					return i>0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//充值金额
	@Override
	public boolean increase(String phonum, double money,Date d) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select membalance from MemberTable where memphone=?";
		//创建临时变量存储余额
		double a;
		try {
			ResultSet rs = this.db.query(sql, phonum);
			if(rs.next()){
				a=rs.getDouble("membalance")+money;
				String sql2="update MemberTable set (membalance,memdate)=(select ?,? from dual) where memphone=?";
				int i = this.db.update(sql2,a,d,phonum);
				return i>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
	//删除会员卡
	@Override
	public boolean deletecard(String phonum) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="delete  from MemberTable where memphone=?";
		try {
			int i = this.db.update(sql,phonum);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	



	

}

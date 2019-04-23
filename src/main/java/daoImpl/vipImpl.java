package daoImpl;

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

	public vip selectById(String phonum) {
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
	//根据姓名手机号冻结
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
	//扣除金额
	@Override
	public boolean deduct(int memnumber,double factprcie) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select membalance from MemberTable where memnumber=?";
		//创建临时变量存储余额
		double a;
		try {
			ResultSet rs = this.db.query(sql, memnumber);
			if(rs.next()){
				if(rs.getDouble("membalance")>factprcie){
					a=rs.getDouble("membalance")-factprcie;
					String sql2="update MemberTable set membalance=? where memnumber=?";
					int i = this.db.update(sql2,a,memnumber);
					return i>0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	

}

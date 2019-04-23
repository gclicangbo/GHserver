package daoImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import dao.bilDao;
import modal.bill;
import modal.menu;
import util.DBUtil;

public class bilImpl implements bilDao{
	private DBUtil db;
	//查询当天总收入金额
	public double selectBsame(Date d) {
		// TODO Auto-generated method stub
		this.db=new DBUtil();
		double sumbill=0.0;
		String sql="select sum(bilcost) from Bills where bildate=?";
		try {
			ResultSet rs = this.db.query(sql,d);
			while(rs.next()){
				return rs.getDouble("sum(bilcost)");
			}
			return sumbill;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//查询账单
	public List<bill> selectBill() {
		this.db=new DBUtil();
		String sql="select * from Bills";
		try {
			ResultSet rs = this.db.query(sql);
			List<bill> list=new ArrayList<bill>();
			while(rs.next()){
				list.add(new bill(rs.getString("bilnumber"),rs.getString("bildate")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//打印小票
	public List<bill> print(String billid) {
		this.db=new DBUtil();
		String sql="select b.*,m.menuenumber,m.dishes,m.price from Bills b,MenueDetails m where b.bilnumber=?";
		try {
			ResultSet rs = this.db.query(sql,billid);
			List<bill> list=new ArrayList<bill>();
			if(rs.next()){
				list.add(new bill(rs.getString("bilnumber"),rs.getString("bildate") ,rs.getDouble("bilcost"), new menu(rs.getInt("menuenumber"), rs.getString("dishes"),rs.getDouble("price"))));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//结算最新的账单
	@Override
	public double amountall(String bilnumber) {
		this.db=new DBUtil();
		String sql="select m.price*n.memamount from MenueDetails m,(select dishes,memamount from MemberDetails where bilnumber=?) n where m.dishes=n.dishes";
		double sumamount=0.0;
		try {
			ResultSet rs = this.db.query(sql,bilnumber);
			while(rs.next()){
				sumamount=sumamount+rs.getDouble("m.price*n.memamount");
			}
			return sumamount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//点菜
	@Override
	public boolean adddishes(String bilnumber, int memnumber, String dishes, double memamount) {
		this.db=new DBUtil();
		String sql="insert into MemberDetails values(?,?,?,?)";
		try {
			int i = this.db.update(sql, bilnumber,memnumber,dishes,memamount);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

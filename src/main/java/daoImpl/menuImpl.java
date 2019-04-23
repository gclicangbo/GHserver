package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.menuDao;
import modal.menu;
import util.DBUtil;

public class menuImpl implements menuDao{
	private DBUtil db;
	//查看菜单
	public List<menu> selectAll() {
		// TODO Auto-generated method stub
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="select md.menuenumber,md.dishes,md.price,ml.cuiname from MenueDetails md,MenueList ml where md.cuinumber=ml.cuinumber";
		try {
			ResultSet rs = this.db.query(sql);
			List<menu> list=new ArrayList<menu>();
			while(rs.next()){
				list.add(new menu(rs.getInt("menuenumber"),rs.getString("dishes"),rs.getDouble("price"),rs.getString("cuiname")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加菜名
	public boolean addFood(menu m) {
		//实例化DBUtil()
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into MenueDetails values(?,?,?,?)";
		try {
			int i = this.db.update(sql,m.getMenuenumber(),m.getDishes(),m.getPrice(),m.getCuiname());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//删除菜名
	public boolean deleteFood(String dishes) {
		// 实例化dbutil对象
		this.db=new DBUtil();
	    //创建sql语句
		String sql="delete from MenueDetails where dishes=?";
		try {
			return this.db.update(sql,dishes)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//修改菜名
	public boolean updateFood(String dishes,String newdishes) {
		// 实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="update MenueDetails set dishes=? where dishes =?";
		try {
			return this.db.update(sql,newdishes,dishes)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改菜价
	@Override
	public boolean updateFood(String dishes, double price) {
		// TODO Auto-generated method stub
		// 实例化dbutil对象
				this.db=new DBUtil();
				//创建sql语句
				String sql="update MenueDetails set price=? where dishes =?";
				try {
					return this.db.update(sql,price,dishes)>0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
	}
	//查看菜名信息
	@Override
	public menu selectFood(String dishes) {
		// TODO Auto-generated method stub
		// 实例化dbutil对象
		this.db=new DBUtil();
	    //创建sql语句
		String sql="select * from MenueDetails where dishes=?";
		try {
			ResultSet rs = this.db.query(sql,dishes);
			while(rs.next()){
				return new menu(rs.getInt("menuenumber"), rs.getString("dishes"),rs.getDouble("price"), rs.getString("cuinumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}

	

}

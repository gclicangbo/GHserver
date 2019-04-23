package dao;

import java.util.List;

import modal.menu;

public interface menuDao {
	//查看菜单
	public List<menu> selectAll();
	//添加菜名
	public boolean addFood(menu m);
	//删除菜名
	public boolean deleteFood(String dishes);
	//修改菜名
	public boolean updateFood(String dishes,String newdishes);
	//修改菜价
	public boolean updateFood(String dishes,double price);
	//查看菜品的信息
	public menu selectFood(String dishes);
}

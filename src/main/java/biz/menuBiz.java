package biz;

import java.util.List;

import modal.menu;

public interface menuBiz {
		//查看菜单
		public List<menu> selectAll();
		//添加菜名
		public String addFood(menu m);
		//删除菜名
		public String deleteFood(String fn);
		//修改菜名
		public String updateFood(String dishes,String newdishes);
		//修改菜价
		public String updateFood(String dishes,double price);
}

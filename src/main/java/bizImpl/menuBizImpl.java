package bizImpl;

import java.util.List;

import biz.menuBiz;
import dao.menuDao;
import daoImpl.menuImpl;
import modal.menu;

public class menuBizImpl implements menuBiz{
	private menuDao md;
	
	public menuBizImpl() {
		super();
		this.md = new menuImpl();
	}

	public List<menu> selectAll() {
		// TODO Auto-generated method stub
		return md.selectAll();
	}

	@Override
	public String addFood(menu m) {
		// TODO Auto-generated method stub
		return this.md.addFood(m)?"添加成功":"添加失败";
	}

	@Override
	public String deleteFood(String fn) {
		// TODO Auto-generated method stub
		return this.md.deleteFood(fn)?"删除成功":"删除失败";
	}

	@Override
	public String updateFood(String dishes,String newdishes) {
		// TODO Auto-generated method stub
		return this.md.updateFood(dishes, newdishes)?"修改成功":"修改失败";
	}

	@Override
	public String updateFood(String dishes, double price) {
		// TODO Auto-generated method stub
		return this.md.updateFood(dishes, price)?"修改成功":"修改失败";
	}

	

	

}

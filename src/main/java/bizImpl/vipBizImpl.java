package bizImpl;

import java.sql.Date;
import java.util.List;

import biz.vipBiz;
import dao.vipDao;
import daoImpl.vipImpl;
import modal.vip;

public class vipBizImpl implements vipBiz{
	private vipDao vd;
	
	public vipBizImpl() {
		super();
		this.vd = new vipImpl();
	}

	@Override
	public String addvip(vip v) {
		// TODO Auto-generated method stub
		return this.vd.addvip(v)?"添加成功":"添加失败";
	}

	@Override
	public List<vip> selectAll() {
		// TODO Auto-generated method stub
		return this.vd.selectAll();
	}

	@Override
	public vip selectByphone(String phonum) {
		// TODO Auto-generated method stub
		return this.vd.selectByphone(phonum);
	}

	@Override
	public String Freezacc(String memname, String memphone) {
		// TODO Auto-generated method stub
		return this.vd.Freezacc(memname, memphone)?"冻结成功":"冻结失败";
	}

	@Override
	public String deduct(String phonum, double factprcie) {
		// TODO Auto-generated method stub
		return this.vd.deduct(phonum, factprcie)?"扣除成功":"扣除失败";
	}

	@Override
	public String increase(String phonum, double money, Date d) {
		// TODO Auto-generated method stub
		return this.vd.increase(phonum, money, d)?"充值成功":"充值失败";
	}

	@Override
	public String deletecard(String phonum) {
		// TODO Auto-generated method stub
		return this.vd.deletecard(phonum)?"删除成功":"删除失败";
	}

	@Override
	public String jf(String memname, String memphone) {
		// TODO Auto-generated method stub
		return this.vd.jf(memname, memphone)?"解除成功":"解除失败";
	}

	

	
}

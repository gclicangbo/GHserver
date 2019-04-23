package bizImpl;

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
	public vip selectById(String phonum) {
		// TODO Auto-generated method stub
		return this.vd.selectById(phonum);
	}

	@Override
	public String Freezacc(String memname, String memphone) {
		// TODO Auto-generated method stub
		return this.vd.Freezacc(memname, memphone)?"冻结成功":"冻结失败";
	}

	@Override
	public String deduct(int memnumber, double factprcie) {
		// TODO Auto-generated method stub
		return this.vd.deduct(memnumber, factprcie)?"扣除成功":"扣除失败";
	}

	

	
}

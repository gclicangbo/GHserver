package bizImpl;

import java.sql.Date;
import java.util.List;

import biz.billBiz;
import dao.bilDao;
import daoImpl.bilImpl;
import modal.bill;

public class billBizImpl implements billBiz{
	private bilDao b;
	
	public billBizImpl() {
		super();
		this.b = new bilImpl();
	}

	public double selectBsame(Date d) {
		// TODO Auto-generated method stub
		return this.b.selectBsame(d);
	}

	public List<bill> selectBill() {
		// TODO Auto-generated method stub
		return this.b.selectBill();
	}

	public List<bill> print(String billid) {
		// TODO Auto-generated method stub
		return this.b.print(billid);
	}

	@Override
	public double amountall(String bilnumber) {
		// TODO Auto-generated method stub
		return this.b.amountall(bilnumber);
	}

	@Override
	public String adddishes(String bilnumber, int memnumber, String dishes, double memamount) {
		// TODO Auto-generated method stub
		return this.b.adddishes(bilnumber, memnumber, dishes, memamount)?"添加成功":"添加失败";
	}

	@Override
	public String addBills(String bilnumber, Date d, double bilcost) {
		// TODO Auto-generated method stub
		return this.b.addBills(bilnumber, d, bilcost)?"插入成功":"插入失败";
	}

	@Override
	public List<bill> print() {
		// TODO Auto-generated method stub
		return this.b.print();
	}

}

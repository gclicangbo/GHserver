package GHserver.maven.GHserver;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import daoImpl.bilImpl;
import daoImpl.menuImpl;
import daoImpl.userImpl;
import daoImpl.vipImpl;
import modal.bill;
import modal.menu;
import modal.user;
import modal.vip;
import util.DBUtil;


public class DaoTest {
	@Test
	public void ver(){
	/*	menuImpl men=new menuImpl();
		List<menu> list = men.selectAll();
		for (menu m : list) {
			System.out.println(m.getCuiname()+"\t"+m.getMenuenumber()+"\t"+m.getDishes()+" \t"+m.getPrice());
		}*/
		vipImpl v=new vipImpl();
		/*boolean c = v.increase("13888888888",300,Date.valueOf("2019-04-24"));
		System.out.println(c);*/
		boolean c = v.deletecard("23467778899");
		System.out.println(c);
		/*boolean c = v.deduct("13888888888", 100);
		System.out.println(c);*/
		/*vip vip = v.selectById("13888888888");
		System.out.println(vip.getMemname());*/
		/*boolean c = v.deduct(666,500);
		System.out.println(c);*/
//		v.addvip(new vip(666,"王松", "13888888888", 500,Date.valueOf("2019-04-22"), 1));
		/*boolean b = v.Freezacc("王松", "13888888888");
		System.out.println(b);*/
		bilImpl b=new bilImpl();
		/*List<bill> list = b.print();
		for (bill bill : list) {
			System.out.println(bill.getM().getDishes()+","+bill.getV().getMemnumber()+","+bill.getBildate());
		}*/
		/*double d = b.selectBsame(Date.valueOf("2019-04-22"));
		System.out.println(d);*/
		/*List<bill> list = b.print("b4c2751223df4bf496430aeed04d86f5",Date.valueOf("2019-04-22"),600.0);
		for (bill bill : list) {
			System.out.println(bill.getM().getDishes());
		}
		*/
		/*boolean c = b.addBills("123456789", Date.valueOf("2019-04-23"), 1250);
		System.out.println(c);*/
		/*List<bill> list = b.print("123456789");
		for (bill bill : list) {
			System.out.println(bill.getM().getDishes());
		}*/
		
	}
}

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
		
		vipImpl v=new vipImpl();
		boolean c = v.deduct(666,500);
		System.out.println(c);
//		v.addvip(new vip(666,"王松", "13888888888", 500,Date.valueOf("2019-04-22"), 1));
		/*boolean b = v.Freezacc("王松", "13888888888");
		System.out.println(b);*/
		bilImpl b=new bilImpl();
		/*double d = b.selectBsame(Date.valueOf("2019-04-22"));
		System.out.println(d);*/
		
		
		
	}
}

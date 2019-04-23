package bizImpl;

import java.util.List;

import biz.userBiz;
import dao.userDao;
import daoImpl.userImpl;
import modal.user;

public class userBizImpl implements userBiz{
	private userDao ud;
	
	public userBizImpl() {
		super();
		this.ud=new userImpl();
	}

	@Override
	public String verifyuser(String uname,String uaccount,int upassword,int uleavl) {
		// TODO Auto-generated method stub
		return ud.verifyuser(uname, uaccount, upassword,uleavl)?"登录成功":"登录失败";
	}

	@Override
	public String adduser(user u) {
		// TODO Auto-generated method stub
		return ud.adduser(u)?"添加成功":"添加失败";
	}

	@Override
	public String deleteuser(String uid) {
		// TODO Auto-generated method stub
		return ud.deleteuser(uid)?"删除成功":"删除失败";
	}

	@Override
	public List<user> selectAll() {
		// TODO Auto-generated method stub
		return ud.selectAll();
	}

	@Override
	public user selectById(String uid) {
		// TODO Auto-generated method stub
		return ud.selectById(uid);
	}


	
	
}

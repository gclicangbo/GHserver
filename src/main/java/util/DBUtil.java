package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	
	public DBUtil() {
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("prop.properties"));
			Class.forName(prop.getProperty("className")).newInstance();
			//获取连接对象
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//创建增删改的方法
	//1.不需要参数，非预编译
	public int update(String sql) throws SQLException{
		stmt=conn.createStatement();
		return stmt.executeUpdate(sql);
	}
	//2.需要参数，预编译
	public int update(String sql,Object...arr) throws SQLException{
		pstmt=conn.prepareStatement(sql);
		//给?赋值
		for (int i = 0; i < arr.length; i++) {
			pstmt.setObject((i+1), arr[i]);
		}
		return pstmt.executeUpdate();
	}
	
	//创建查询的方法
	//1.非预编译
	public ResultSet query(String sql) throws SQLException{
		stmt=conn.createStatement();
		return stmt.executeQuery(sql);
	}
	//2.预编译
	public ResultSet query(String sql,Object...arr) throws SQLException{
		pstmt=conn.prepareStatement(sql);
		//给?赋值
		for (int i = 0; i < arr.length; i++) {
			pstmt.setObject((i+1), arr[i]);
		}
		return pstmt.executeQuery();
	}
	//创建关闭资源的方法
	public void closed(){
		try {
			if(stmt!=null&&!stmt.isClosed())stmt.close();
			if(conn!=null&&!conn.isClosed())conn.close();
			if(pstmt!=null&&!pstmt.isClosed())pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

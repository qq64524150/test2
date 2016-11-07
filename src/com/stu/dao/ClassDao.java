package com.stu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stu.entity.Cclass;

/*
 * 班级的相关dao方法
 * */
public class ClassDao {
	//添加
	public boolean addClass(Cclass cclass) throws SQLException{
		String sql="insert into gclass values(class_sequence.nextval,?,?,default);";
		return OraclsJDBC.updateDb(sql,new Object[]{cclass.getGname(),cclass.getGclassno()});
		
	}
	//删除
	public boolean delClass(){
		return false ;
	}
	
	//查询  -- id
	public Cclass checkClass(String id ){
		//获取链接对象
		Connection conn = OraclsJDBC.getConnection();
		Statement st = null ;
		ResultSet rs = null ;
		String sql="select * from gclass where gno="+id;
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			Cclass cclass = new Cclass(); 
			if(rs.next()){
				cclass.setGno(rs.getString(1));
				cclass.setGname(rs.getString(2));
				cclass.setGclassno(rs.getString(3));
				cclass.setGtime(rs.getString(4));
			}
			return cclass;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}
	//修改
	
	public boolean updataClass(Cclass cclass) throws SQLException{
		String sql ="update gclass set gname=?,gclassno=? where gno="+cclass.getGno();
		return OraclsJDBC.updateDb(sql, new Object[]{cclass.getGname(),cclass.getGclassno()});
		
		
		
	}
	
	
}

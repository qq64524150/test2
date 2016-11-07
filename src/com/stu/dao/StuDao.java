package com.stu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stu.entity.Cclass;
import com.stu.entity.Stu;

public class StuDao {
	//添加学生信息
	
	public boolean addStu(Stu stu) throws SQLException{
		String sql ="insert into stuinfo values(stu_sequence.nextval,?,?,?,?,default)" ;
		return OraclsJDBC.updateDb(sql,new Object[]{stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSclassno()}) ;
	}
	
	//删除
	public boolean delStu(String sno) throws SQLException{
		return OraclsJDBC.updateDb("delete stuinfo where sno = "+sno) ;
	}
	
	
	//修改

	public boolean updataStu(Stu stu,String sno) throws SQLException{
		String sql ="update stuinfo set sname=?,ssex=?,sage=?,sclassno=? where sno="+sno ;
		return OraclsJDBC.updateDb(sql,new Object[]{stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSclassno()}) ;
	}
	
	
	
	//查询所有学生信息及班级信息
	public List getStuList(){
		//获取链接数据库的对象
		Connection conn = OraclsJDBC.getConnection(); 
		Statement st = null ;
		ResultSet rs = null ;
		
		try {
			st = conn.createStatement();
			String sql ="select s.*,g.gname from stuinfo s ,gclass g where s.sclassno=g.gclassno order by  s.sclassno ";
			rs = st.executeQuery(sql) ;
			List list = new ArrayList() ;
			while(rs.next()){
				//以数组形式存放学生信息
				String[] stus = new String[7] ;
				for(int i = 0 ;i<stus.length;i++){
					stus[i] = rs.getString(i+1);
				}
				list.add(stus);
			}
			return list ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			OraclsJDBC.closeDb(conn, st, rs);
		}
		return null ;
		
	}
	//获取班级信息
	public List<Cclass> getAllClass(){
		
		//获取链接数据库的对象
		Connection conn = OraclsJDBC.getConnection(); 
		Statement st = null ;
		ResultSet rs = null ;
		String sql = "select * from gclass order by gclassno " ;
		try {
			st = conn.createStatement() ;
			rs = st.executeQuery(sql) ;
			List<Cclass> list = new ArrayList<Cclass>() ;
			while(rs.next()){
				Cclass cclass = new Cclass() ;
				
				cclass.setGno(rs.getString(1));
				cclass.setGname(rs.getString(2));
				cclass.setGclassno(rs.getString(3));
				cclass.setGtime(rs.getString(4));
				
				list.add(cclass) ;
			}
			return list ;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OraclsJDBC.closeDb(conn, st, rs);
		}
		
		return null ;
		
		
	}
	
	
	
	
	
}

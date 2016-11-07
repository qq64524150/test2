package com.stu.web;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.stu.dao.ClassDao;
import com.stu.dao.StuDao;
import com.stu.entity.Cclass;

public class AllClass {
	
	private Cclass cclass ;

	
	
	//获取ActionContext对象里的方法，把数据设置在作用域中
	ActionContext ext = ActionContext.getContext();
	
	//查看班级信息
	public String doClassLisr(){
		//调用dao里面的查询班级的方法
		List<Cclass> classList = new StuDao().getAllClass() ;
		ext.getSession().put("classList", classList);
		return "classList" ;
	}
	
	//添加班级信息
	public String addClass() throws SQLException{
		//调用dao里面的添加班级方法
		if(new ClassDao().updataClass(cclass)){
			
		}
		
		
		
		return doClassLisr();
	}
	//修改班级
	public String upClass() throws SQLException{
		cclass = new ClassDao().checkClass(cclass.getGno());
		
		return "updataClass" ;
	}
	
	public Cclass getCclass() {
		return cclass;
	}

	public void setCclass(Cclass cclass) {
		this.cclass = cclass;
	} 
	
	
	
	
	
	
}

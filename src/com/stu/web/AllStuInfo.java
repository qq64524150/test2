package com.stu.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.stu.dao.StuDao;
import com.stu.entity.Cclass;
import com.stu.entity.Stu;

public class AllStuInfo {
	//---测试的
	private Stu stu ;
	private Cclass cclass ;
	
	private String sno ;
	//获取dao对象里面的方法
	StuDao dao = new StuDao();
	//获取ActionContext对象里的方法
	ActionContext ctx = ActionContext.getContext();
	//获取httpServletResponse对象
	HttpServletResponse response = ServletActionContext.getResponse();
	
	//查询出全部
	public String allStuinfo(){
		//获取dao对象里面的方法 -- 查询全部学生信息与班级名称
		Map sesston = ctx.getSession();
		List list = dao.getStuList() ;
		sesston.put("allStu", list);
		//获取班级编号
		List<Cclass> lsitCalss = dao.getAllClass();
		Map sesstons = ctx.getSession();
		//把班级编号存放在session作用域中
		sesstons.put("classtList", lsitCalss);
		return "welecome" ;
	}
	
	//添加信息
	public String addStu() {
		//封装数据
		Stu stus = new Stu("",stu.getSname(),stu.getSsex(),stu.getSage(),cclass.getGclassno(),"");
		
		//获取打印流
		PrintWriter out = null ;
		try {
			out = response.getWriter() ;
			if(dao.addStu(stus)){
				out.print("1");
			}
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			//关闭打印流
			out.close();
		}
		
		
		return null ;
	}

	
	//修改
	public String updataStu(){
		//封装数据
		Stu stus = new Stu("",stu.getSname(),stu.getSsex(),stu.getSage(),cclass.getGclassno(),"");
		//获取打印流
		PrintWriter out = null ;
		
		try {
			if(dao.updataStu(stus, stu.getSno())){
				out = response.getWriter() ;
				out.print("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//关闭输出流
			out.close();
		}
		
		return null ;
	}
	//删除
	public String dalStu() {
		System.out.println("----"+sno);
		//获取打印流
		PrintWriter out = null ;
		try {
			if(dao.delStu(getSno())){
				out = response.getWriter() ;
				out.print("1");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
		return null ;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}

	public Cclass getCclass() {
		return cclass;
	}

	public void setCclass(Cclass cclass) {
		this.cclass = cclass;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	
}

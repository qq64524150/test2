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
	//---���Ե�
	private Stu stu ;
	private Cclass cclass ;
	
	private String sno ;
	//��ȡdao��������ķ���
	StuDao dao = new StuDao();
	//��ȡActionContext������ķ���
	ActionContext ctx = ActionContext.getContext();
	//��ȡhttpServletResponse����
	HttpServletResponse response = ServletActionContext.getResponse();
	
	//��ѯ��ȫ��
	public String allStuinfo(){
		//��ȡdao��������ķ��� -- ��ѯȫ��ѧ����Ϣ��༶����
		Map sesston = ctx.getSession();
		List list = dao.getStuList() ;
		sesston.put("allStu", list);
		//��ȡ�༶���
		List<Cclass> lsitCalss = dao.getAllClass();
		Map sesstons = ctx.getSession();
		//�Ѱ༶��Ŵ����session��������
		sesstons.put("classtList", lsitCalss);
		return "welecome" ;
	}
	
	//�����Ϣ
	public String addStu() {
		//��װ����
		Stu stus = new Stu("",stu.getSname(),stu.getSsex(),stu.getSage(),cclass.getGclassno(),"");
		
		//��ȡ��ӡ��
		PrintWriter out = null ;
		try {
			out = response.getWriter() ;
			if(dao.addStu(stus)){
				out.print("1");
			}
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			//�رմ�ӡ��
			out.close();
		}
		
		
		return null ;
	}

	
	//�޸�
	public String updataStu(){
		//��װ����
		Stu stus = new Stu("",stu.getSname(),stu.getSsex(),stu.getSage(),cclass.getGclassno(),"");
		//��ȡ��ӡ��
		PrintWriter out = null ;
		
		try {
			if(dao.updataStu(stus, stu.getSno())){
				out = response.getWriter() ;
				out.print("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//�ر������
			out.close();
		}
		
		return null ;
	}
	//ɾ��
	public String dalStu() {
		System.out.println("----"+sno);
		//��ȡ��ӡ��
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

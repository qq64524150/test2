package com.stu.web;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.stu.dao.ClassDao;
import com.stu.dao.StuDao;
import com.stu.entity.Cclass;

public class AllClass {
	
	private Cclass cclass ;

	
	
	//��ȡActionContext������ķ�������������������������
	ActionContext ext = ActionContext.getContext();
	
	//�鿴�༶��Ϣ
	public String doClassLisr(){
		//����dao����Ĳ�ѯ�༶�ķ���
		List<Cclass> classList = new StuDao().getAllClass() ;
		ext.getSession().put("classList", classList);
		return "classList" ;
	}
	
	//��Ӱ༶��Ϣ
	public String addClass() throws SQLException{
		//����dao�������Ӱ༶����
		if(new ClassDao().updataClass(cclass)){
			
		}
		
		
		
		return doClassLisr();
	}
	//�޸İ༶
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

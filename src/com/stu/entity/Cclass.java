package com.stu.entity;
/**
 * 创建班级实体对象
 * @author z
 *
 */
public class Cclass {

	private String gno;
	private String gname ;
	private String gclassno ;
	private String gtime ;
	
	
	
	
	
	public Cclass() {
		
	}
	
	public Cclass(String gno, String gname, String gclassno, String gtime) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.gclassno = gclassno;
		this.gtime = gtime;
	}

	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGclassno() {
		return gclassno;
	}
	public void setGclassno(String gclassno) {
		this.gclassno = gclassno;
	}
	public String getGno() {
		return gno;
	}
	public void setGno(String gno) {
		this.gno = gno;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	} 
	
	
	
	
	
}

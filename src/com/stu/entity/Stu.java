package com.stu.entity;
/*
 * 创建学生实体
 * */
public class Stu {

	private String sno  ;
    private String sname ;
    private String ssex ;
    private String sage ;
    private String sclassno ;
    private String stime ;

    
	public Stu() {
	}
	public Stu(String sno, String sname, String ssex, String sage, String sclassno, String stime) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.sclassno = sclassno;
		this.stime = stime;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public String getSclassno() {
		return sclassno;
	}
	public void setSclassno(String sclassno) {
		this.sclassno = sclassno;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
    
    
    
    
    
    
}

--创建序列号 -- 学生
create sequence stu_sequence
increment by 1   
start with 201600
--创建序列号 -- 班级
create sequence class_sequence
increment by 1
start with 1


--创建学生信息表

create table stuinfo
(
       sno number primary key ,
       sname varchar2(30),
       ssex varchar2(2),
       sage number ,
       sclassno number,
       stime date default sysdate      
)
--创建班级信息表
create table gclass
(
    gno number primary key ,
    gname varchar2(30),
    gclassno number , 
    gtime date default sysdate    
)
--测试添加信息 -- 学生
insert into stuinfo values(stu_sequence.nextval,'zhangsan','男','20',1,default);
insert into stuinfo values(stu_sequence.nextval,'lisi','男','20',2,default);
insert into stuinfo values(stu_sequence.nextval,'zhangsan2','男','20',2,default);
insert into stuinfo values(stu_sequence.nextval,'xiaohow','女','20',2,default);


--测试添加学校 -- 班级
insert into gclass values(class_sequence.nextval,'122',1,default);
insert into gclass values(class_sequence.nextval,'121',2,default);

--查看数据--学生
select * from stuinfo ;
--查看数据--班级 
select * from gclass ;

--多表 
select s.*,g.gname from stuinfo s ,gclass g where s.sclassno=g.gclassno  order by s.sclassno  and s.sno = 201605 

--修改
update stuinfo set sname='xxx',ssex='女',sage='11',sclassno='1' where sno=201609;
--删除
delete stuinfo where sno = 201610




delete stuinfo 
commit;

drop table stuinfo
commit ;










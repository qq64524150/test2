--�������к� -- ѧ��
create sequence stu_sequence
increment by 1   
start with 201600
--�������к� -- �༶
create sequence class_sequence
increment by 1
start with 1


--����ѧ����Ϣ��

create table stuinfo
(
       sno number primary key ,
       sname varchar2(30),
       ssex varchar2(2),
       sage number ,
       sclassno number,
       stime date default sysdate      
)
--�����༶��Ϣ��
create table gclass
(
    gno number primary key ,
    gname varchar2(30),
    gclassno number , 
    gtime date default sysdate    
)
--���������Ϣ -- ѧ��
insert into stuinfo values(stu_sequence.nextval,'zhangsan','��','20',1,default);
insert into stuinfo values(stu_sequence.nextval,'lisi','��','20',2,default);
insert into stuinfo values(stu_sequence.nextval,'zhangsan2','��','20',2,default);
insert into stuinfo values(stu_sequence.nextval,'xiaohow','Ů','20',2,default);


--�������ѧУ -- �༶
insert into gclass values(class_sequence.nextval,'122',1,default);
insert into gclass values(class_sequence.nextval,'121',2,default);

--�鿴����--ѧ��
select * from stuinfo ;
--�鿴����--�༶ 
select * from gclass ;

--��� 
select s.*,g.gname from stuinfo s ,gclass g where s.sclassno=g.gclassno  order by s.sclassno  and s.sno = 201605 

--�޸�
update stuinfo set sname='xxx',ssex='Ů',sage='11',sclassno='1' where sno=201609;
--ɾ��
delete stuinfo where sno = 201610




delete stuinfo 
commit;

drop table stuinfo
commit ;










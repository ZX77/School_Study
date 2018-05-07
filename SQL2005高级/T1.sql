--���̱�
create table project(
	projectId varchar(10) not null primary key,
	projectName varchar(50) not null
)
go
--ְλ��
create table Degree(
	degreeId int identity(1,1) primary key,
	degreeName varchar(30) not null,
	workMoney decimal(18,2)	
)
go
--drop table Employee;

--ְ����
create table Employee(
	empId	varchar(10) not null primary key,
	empName varchar(30) not null,
	degreeId int references Degree(degreeId)
)
go
--������ϸ��
create table WorkDetail(
	workId int identity(1,1) primary key,
	projectId varchar(10) not null,
	empId varchar(10) not null,
	workTime	decimal(18,2) --����ʱ����Сʱ��
)
go
alter table WorkDetail add constraint fk_WorkDetail_Project foreign key(projectId) references Project(projectId);
alter table WorkDetail add constraint fk_WorkDetail_Employee foreign key(empId) references Employee(empId);

delete employee where empid='ht001';


insert into project values('A1','��԰����');
insert into project values('A2','ɳʯ����');
insert into project values('B1','������');
insert into project values('B2','�Ƹ���');
select *from project;
insert into degree values('����Ա',60);
insert into degree values('����ʦ',65);
insert into degree values('��ʦ',65);
select * from degree;
insert into employee values('ht001','����',1);
insert into employee values('ht002','����',2);
insert into employee values('ht003','������',3);
insert into employee values('ht004','С��',2);
insert into employee values('ht005','��С��',2);
insert into employee values('ht006','������',1);
select * from employee;

insert into WorkDetail values('A2','ht007',1);


insert into WorkDetail values('A1','ht001',1);
insert into WorkDetail values('A2','ht002',1.5);
insert into WorkDetail values('B1','ht003',3);
insert into WorkDetail values('B2','ht001',2.5);
insert into WorkDetail values('A1','ht002',4);
insert into WorkDetail values('A2','ht003',3.6);
insert into WorkDetail values('B1','ht003',2.4);
insert into WorkDetail values('B2','ht002',3.3);
insert into WorkDetail values('A1','ht005',8);
insert into WorkDetail values('A2','ht006',6);

insert into WorkDetail values('A1','ht001',3);
insert into WorkDetail values('A2','ht002',2.5);
insert into WorkDetail values('B1','ht003',2);
insert into WorkDetail values('B2','ht001',1.5);
insert into WorkDetail values('A1','ht002',2);
insert into WorkDetail values('A2','ht003',5.6);
insert into WorkDetail values('B1','ht003',4.4);
insert into WorkDetail values('B2','ht002',2.3);
insert into WorkDetail values('A1','ht005',3);
insert into WorkDetail values('A2','ht006',2);

select * from WorkDetail;
--�������
--������inner join
--������
	--1.�������ӣ�left join(left outer join)
	--2.�������ӣ�right join(right outer join);
	--3.��ȫ���ӣ�full join 
--��������cross join

select * from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId

select projectName,e.empId,empName,degreeName,WorkMoney,WorkTime,WorkMoney*WorkTime ���� from WorkDetail w
left join Project p on w.projectId=p.projectId
left join Employee e on w.empId = e.empid
left join Degree d on  e.degreeId = d.degreeId

select projectName,e.empId,empName,degreeName,sum(WorkMoney*WorkTime) ���� from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
group by projectName,e.empId,empName,degreeName


--�Ӳ�ѯ
--��ѯ���еĹ���ʦ
select * from employee where degreeId =(select degreeId from degree where degreename='����ʦ')--�Ӳ�ѯ����һ����¼
select * from employee where degreeId in(select degreeId from degree where degreename='����ʦ')--�Ӳ�ѯ���ض�����¼
--ÿ��Ա�������˼�Сʱ
select empid,empname,(select sum(WorkTime) from workdetail where empid=e.empid) ����ʱ��  from employee e;

select * from employee;
--��ѯ���еĹ���ʦ�����ұ��浽һ���±�aa����
select * into aa from employee where degreeId =(select degreeId from degree where degreename='����ʦ')
select * from aa;
truncate table aa;
insert into aa select * from employee where degreeId =(select degreeId from degree where degreename='����ʦ')
 


select empid,empname,degreename from employee e inner join degree d on e.degreeid=d.degreeid where  degreename='����ʦ'


select empid,empname,degreename from employee e inner join degree d on e.degreeid=d.degreeid
--�������ӣ��������
select empid,empname,degreename from employee e cross join degree d order by empid;

--having 
select projectName,e.empId,empName,degreeName,sum(WorkMoney*WorkTime) ���� from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
where projectName='��԰����'
group by projectName,e.empId,empName,degreeName
having sum(WorkMoney*WorkTime)>=700
order by empid;


select projectName,empName,sum(WorkMoney*WorkTime) ���� from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
where projectName='��԰����'
group by projectName,empName
having sum(WorkMoney*WorkTime)>=700
order by empname;


--��ѯ��û��Ա��û������Ŀ����
select * from employee e where not exists (select * from workdetail where empid = e.empid)
--union����ѯ�����ṹ��ͬ���߼��ݵ�����,��ͬ����ֻ��ʾһ��
select * from employee
union
select * from aa;
insert into aa values('ht007','������',1);



select empName,WorkMoney*WorkTime ���� from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
order by empName compute sum(WorkMoney*WorkTime) by empName

--distinct�����ظ���¼
select distinct degreeName from employee e inner join degree d on e.degreeid=d.degreeid;


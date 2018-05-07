--工程表
create table project(
	projectId varchar(10) not null primary key,
	projectName varchar(50) not null
)
go
--职位表
create table Degree(
	degreeId int identity(1,1) primary key,
	degreeName varchar(30) not null,
	workMoney decimal(18,2)	
)
go
--drop table Employee;

--职工表
create table Employee(
	empId	varchar(10) not null primary key,
	empName varchar(30) not null,
	degreeId int references Degree(degreeId)
)
go
--工作明细表
create table WorkDetail(
	workId int identity(1,1) primary key,
	projectId varchar(10) not null,
	empId varchar(10) not null,
	workTime	decimal(18,2) --工作时长（小时）
)
go
alter table WorkDetail add constraint fk_WorkDetail_Project foreign key(projectId) references Project(projectId);
alter table WorkDetail add constraint fk_WorkDetail_Employee foreign key(empId) references Employee(empId);

delete employee where empid='ht001';


insert into project values('A1','花园大厦');
insert into project values('A2','沙石大桥');
insert into project values('B1','九龙湾');
insert into project values('B2','财富港');
select *from project;
insert into degree values('技术员',60);
insert into degree values('工程师',65);
insert into degree values('律师',65);
select * from degree;
insert into employee values('ht001','张三',1);
insert into employee values('ht002','李四',2);
insert into employee values('ht003','王麻子',3);
insert into employee values('ht004','小丽',2);
insert into employee values('ht005','李小龙',2);
insert into employee values('ht006','张三丰',1);
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
--多表连接
--内连接inner join
--外链接
	--1.左外连接：left join(left outer join)
	--2.右外连接：right join(right outer join);
	--3.完全连接：full join 
--交叉连接cross join

select * from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId

select projectName,e.empId,empName,degreeName,WorkMoney,WorkTime,WorkMoney*WorkTime 工资 from WorkDetail w
left join Project p on w.projectId=p.projectId
left join Employee e on w.empId = e.empid
left join Degree d on  e.degreeId = d.degreeId

select projectName,e.empId,empName,degreeName,sum(WorkMoney*WorkTime) 工资 from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
group by projectName,e.empId,empName,degreeName


--子查询
--查询所有的工程师
select * from employee where degreeId =(select degreeId from degree where degreename='工程师')--子查询返回一条记录
select * from employee where degreeId in(select degreeId from degree where degreename='工程师')--子查询返回多条记录
--每个员工工作了几小时
select empid,empname,(select sum(WorkTime) from workdetail where empid=e.empid) 工作时长  from employee e;

select * from employee;
--查询所有的工程师，并且保存到一个新表（aa）中
select * into aa from employee where degreeId =(select degreeId from degree where degreename='工程师')
select * from aa;
truncate table aa;
insert into aa select * from employee where degreeId =(select degreeId from degree where degreename='工程师')
 


select empid,empname,degreename from employee e inner join degree d on e.degreeid=d.degreeid where  degreename='工程师'


select empid,empname,degreename from employee e inner join degree d on e.degreeid=d.degreeid
--交叉连接：排列组合
select empid,empname,degreename from employee e cross join degree d order by empid;

--having 
select projectName,e.empId,empName,degreeName,sum(WorkMoney*WorkTime) 工资 from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
where projectName='花园大厦'
group by projectName,e.empId,empName,degreeName
having sum(WorkMoney*WorkTime)>=700
order by empid;


select projectName,empName,sum(WorkMoney*WorkTime) 工资 from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
where projectName='花园大厦'
group by projectName,empName
having sum(WorkMoney*WorkTime)>=700
order by empname;


--查询有没有员工没有在项目工作
select * from employee e where not exists (select * from workdetail where empid = e.empid)
--union语句查询多个表结构相同或者兼容的数据,相同数据只显示一条
select * from employee
union
select * from aa;
insert into aa values('ht007','啊啊啊',1);



select empName,WorkMoney*WorkTime 工资 from WorkDetail w
inner join Project p on w.projectId=p.projectId
inner join Employee e on w.empId = e.empid
inner join Degree d on  e.degreeId = d.degreeId
order by empName compute sum(WorkMoney*WorkTime) by empName

--distinct消除重复记录
select distinct degreeName from employee e inner join degree d on e.degreeid=d.degreeid;


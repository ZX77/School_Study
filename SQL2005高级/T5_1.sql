select * from student;

--5.	课堂练习
--1.	查询出所有员工，sex为M是显示成”男”,F显示成女

select *,case 性别 when '男' then 'M' when '女' then 'F' end 性别1 from student;

--2.	循环将所有员工的工资涨10%，直到最高工资是最低工资的两倍为止
create table emp (empid int identity(1,1) primary key,empName varchar(20),sex char(1),salary decimal(18,2));

insert into emp values('张三','M',2000);
insert into emp values('小丽','F',1800);
insert into emp values('李四','M',2400);
update emp set salary=2000 where empid=1;
update emp set salary=1000 where empid=2;
update emp set salary=2400 where empid=3;


select * from emp;

while 1=1
begin
		update emp set salary = salary*1.1;
		if((select max(salary) from emp)>=(select min(salary)*2 from emp))
		begin
			break;
		end
end;

--3.	写一段T-SQL计算1-100哪些能同时被3和7整除

declare @i int;
set @i=1;
while @i<=100
begin
	if(@i%3=0 and @i %7=0)
	begin
		print cast(@i as varchar(3)) +'能同时被3和7整除'
	end;
	set @i=@i+1;
end;

--4.	使用switch case 写一个例子，根据不同的时间来判断上午，下午，晚上

declare @hour int;
select @hour=datepart(hh,getdate());
select  case 
when @hour>0 and @hour<8 then '早上'
when @hour>=8 and @hour<12 then '上午'
when @hour>=12 and @hour<14 then '中午'
when @hour>=14 and @hour<18 then '下午'
else '晚上' end

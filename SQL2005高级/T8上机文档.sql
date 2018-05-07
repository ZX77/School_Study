--5.1.	写一个过程，计算某个月有多少天。
alter proc up_calcDay
	@year int,
	@month int,
	@day int output
as
	if(@month=1 or @month=3 or @month=5 or @month=7 or @month=8 or @month=10 or @month=12)
	begin
		set @day=31;
	end
	else if(@month=2)
	begin
		if ((@year % 400=0) or (@year %4=0 and @year %100 <> 0))
		begin
			set @day=29;
		end
		else
		begin
			set @day=28;
		end
	end
	else
	begin
		set @day=30;
	end;
	if(@year<1900 or @year>9999)
	begin
		print '请输入有效的年份';
		set @day=0;
	end;
	if (@month<1 or @month>12)
	begin
		print '请输入1~12之间的月份';
		set @day=0;
	end;
	select @day;
go

declare @year int
declare @month int;
declare @day int;
set @year = 2008;
set @month = 21;
execute up_calcday @year,@month,@day output;
select @day;

--------------------------------------
alter proc up_calcDay
	@year int,
	@month int,
	@day int output
as

	if(@year<1900 or @year>9999)
	begin
		print '请输入有效的年份';
		set @day=0;
		return;
	end;
	if (@month<1 or @month>12)
	begin
		print '请输入1~12之间的月份';
		set @day=0;
		return;
	end;
	declare @sdate varchar(20);
	set @sdate = cast(@year as varchar(4)) + '-'+ cast(@month as varchar(2))+'-01';
	select @day = datepart(dd,dateadd(ms,-3,dateadd(mm,1,@sdate)));
	select @day;
go

--------------------------------------
--5.2.	编写一个给所有员工加薪10%的过程，这之后，如果已经雇佣该雇员超过60个月，则给他额外加薪2000.
select * from employee;

create table 员工表
(
	empid int identity(1,1) primary key,
	empname varchar(20),
	sex char(2),
	salary decimal(18,2),
	joindate datetime
)
insert into 员工表 values('张三','男',2000,getdate());
insert into 员工表 values('李四','男',3000,'2010-8-8');
insert into 员工表 values('小丽','女',3500,'2015-9-9');
insert into 员工表 values('王老五','男',4000,getdate());
insert into 员工表 values('张三丰','男',3300,'2011-11-11');
select * from 员工表;

create proc up_addsalary
as
	--给所有员工加薪
	update 员工表 set salary = salary*1.1;
	--给超过入职60个月的员工加薪
	update 员工表 set salary = salary+2000 where empid in(select empid from 员工表 where datediff(mm,joindate,getdate())>60);
go

up_addsalary



alter proc up_addsalary
as
	declare @salary decimal(18,2);
	declare @joindate datetime;
	--定义游标
	declare cur cursor for select salary,joindate from 员工表 for update of salary
	open cur;
	fetch next from cur into @salary,@joindate;
	while @@FETCH_STATUS=0
	begin
		if(datediff(mm,@joindate,getdate())>60)
		begin
			update 员工表 set salary = salary*1.1+2000 where current of cur;
		end;
		else
		begin
			update 员工表 set salary = salary*1.1 where current of cur;
		end;
		fetch next from cur into @salary,@joindate;
	end;
	close cur;
	deallocate cur;
go

---------------------------------------------
--6.1.	写一个自动编号的存储过程，如:200408010001? 
drop table 订单表
create table 订单表
(
	orderid bigint primary key
)
select * from 订单表;
go
alter procedure up_orderId
as
	declare @sdate varchar(12);
	set @sdate = cast(year(getdate()) as varchar(4));
	if(month(getdate())>9)
	begin
		set @sdate =@sdate + cast(month(getdate()) as varchar(2));
	end
	else
	begin
		set @sdate =@sdate + '0'+ cast(month(getdate()) as varchar(2));
	end;
	if(datepart(dd,getdate())>9)
	begin
		set @sdate =@sdate + cast(datepart(dd,getdate()) as varchar(2));
	end
	else
	begin
		set @sdate =@sdate + '0'+ cast(datepart(dd,getdate()) as varchar(2));
	end;
	declare @orderid bigint;
	select @orderid= isnull(max(orderid),0) from 订单表 where orderid like +@sdate+'%';
	set @orderid = @orderid+1;
	if(@orderid=1)
	begin
		set @orderid=cast((@sdate+'0001') as bigint);
	end;
	/*
	if(@orderid<10)
	begin
		set @sdate = @sdate +'000'+@orderid;
	end;
	else if(@orderid>=10 and @orderid<100)
	begin
		set @sdate = @sdate +'00'+@orderid;
	end
	else if(@orderid>=100 and @orderid<1000)
	begin
		set @sdate = @sdate +'0'+@orderid;
	end
	else
	begin
		set @sdate = @sdate +@orderid;
	end;
	*/
	insert into 订单表 values(@orderid);
	select * from 订单表;
go

up_orderId

delete 订单表;

declare @str varchar(20);

--字符串中包含有单引号，怎么处理;
set @str = '''admin''' + '''';
select @str;
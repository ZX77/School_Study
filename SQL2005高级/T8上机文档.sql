--5.1.	дһ�����̣�����ĳ�����ж����졣
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
		print '��������Ч�����';
		set @day=0;
	end;
	if (@month<1 or @month>12)
	begin
		print '������1~12֮����·�';
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
		print '��������Ч�����';
		set @day=0;
		return;
	end;
	if (@month<1 or @month>12)
	begin
		print '������1~12֮����·�';
		set @day=0;
		return;
	end;
	declare @sdate varchar(20);
	set @sdate = cast(@year as varchar(4)) + '-'+ cast(@month as varchar(2))+'-01';
	select @day = datepart(dd,dateadd(ms,-3,dateadd(mm,1,@sdate)));
	select @day;
go

--------------------------------------
--5.2.	��дһ��������Ա����н10%�Ĺ��̣���֮������Ѿ���Ӷ�ù�Ա����60���£�����������н2000.
select * from employee;

create table Ա����
(
	empid int identity(1,1) primary key,
	empname varchar(20),
	sex char(2),
	salary decimal(18,2),
	joindate datetime
)
insert into Ա���� values('����','��',2000,getdate());
insert into Ա���� values('����','��',3000,'2010-8-8');
insert into Ա���� values('С��','Ů',3500,'2015-9-9');
insert into Ա���� values('������','��',4000,getdate());
insert into Ա���� values('������','��',3300,'2011-11-11');
select * from Ա����;

create proc up_addsalary
as
	--������Ա����н
	update Ա���� set salary = salary*1.1;
	--��������ְ60���µ�Ա����н
	update Ա���� set salary = salary+2000 where empid in(select empid from Ա���� where datediff(mm,joindate,getdate())>60);
go

up_addsalary



alter proc up_addsalary
as
	declare @salary decimal(18,2);
	declare @joindate datetime;
	--�����α�
	declare cur cursor for select salary,joindate from Ա���� for update of salary
	open cur;
	fetch next from cur into @salary,@joindate;
	while @@FETCH_STATUS=0
	begin
		if(datediff(mm,@joindate,getdate())>60)
		begin
			update Ա���� set salary = salary*1.1+2000 where current of cur;
		end;
		else
		begin
			update Ա���� set salary = salary*1.1 where current of cur;
		end;
		fetch next from cur into @salary,@joindate;
	end;
	close cur;
	deallocate cur;
go

---------------------------------------------
--6.1.	дһ���Զ���ŵĴ洢���̣���:200408010001? 
drop table ������
create table ������
(
	orderid bigint primary key
)
select * from ������;
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
	select @orderid= isnull(max(orderid),0) from ������ where orderid like +@sdate+'%';
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
	insert into ������ values(@orderid);
	select * from ������;
go

up_orderId

delete ������;

declare @str varchar(20);

--�ַ����а����е����ţ���ô����;
set @str = '''admin''' + '''';
select @str;
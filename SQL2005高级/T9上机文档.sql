--5.1.	员工表创建instert触发器，如果员工名重复，不能插入
select * from emp;
alter table emp add joindate datetime;

update emp set joindate='2014-8-8' where empid=1;
update emp set joindate='2015-8-8' where empid=2;
update emp set joindate='2016-8-8' where empid=3;

alter trigger tr_empadd on emp for insert

as
	declare @empname varchar(20);
	--获取新增员工的姓名；
	select @empname=empname from inserted;
	--如果大于1就有同名的员工
	if (select count(*) from emp where empname=@empname)>1 
	begin
		print '已经存在姓名为【'+@empname+'】的员工，新增失败';
		--回滚
		rollback tran;
	end

go

select * from emp;
insert into emp values('李小龙','M',1800,'2014-3-1');

--5.2.	员工表创建update触发器，如果员工入职查过30个月，工资不能低于2000元
--修改一个员工资料
create trigger tr_empupdate on emp for update

as
	declare @empid int;
	declare @month int;
	declare @salary int;
	select @empid=empid,@salary=salary,@month=(datediff(mm,joindate,getdate())) from inserted;
	if(@month>30 and @salary<2000)
	begin
		print '该员工入职已经超过30个月，最低工资不能低于2000，修改失败';
		rollback transaction;
	end;
go
update emp set salary=2600 where empid=6;
--修改多个员工资料


alter trigger tr_empupdate on emp for update

as
	declare @empname varchar(20);
	declare @month int;
	declare @salary int;
	declare cur cursor  for select empname,salary,(datediff(mm,joindate,getdate())) joindate from inserted;
	open cur;
	fetch next from cur into @empname,@salary,@month;
	while @@FETCH_STATUS=0
	begin
		if(@month>30 and @salary<2000)
		begin
			print @empname+'入职已经超过30个月，最低工资不能低于2000，修改失败';
			rollback transaction;
		end;
		fetch next from cur into @empname,@salary,@month;
	end;
	close cur;
	deallocate cur;
go

select * from emp;
insert into emp values('黄蓉','M',1800,'2013-3-1');
insert into emp values('王五','M',1800,'2012-3-1');
insert into emp values('说说','M',1800,'2017-3-1');

update emp set salary=1700 where empid>9;

--5.3.	员工表中创建delete触发器，未离职的员工不能删除
alter table emp add empstatus varchar(10);
update emp set empstatus='在职' where empid<=6;
update emp set empstatus='离职',salary=3000 where empid>6;
alter trigger tr_empdelete on emp for delete

as
	declare @empname varchar(20);
	declare @empstatus varchar(10);
	select @empname=empname,@empstatus=empstatus from deleted;
	if @empstatus='在职'
	begin
		print @empname+'没有离职，不能删除在职员工，删除失败';
		rollback tran;
	end;
go

delete emp where empid=10;

/*
6.2.	有三个表：
商品表（Product）：有主键、商品名称、商品价格、库存字段
订单表（Orders)：有主键订单号、客户名、客户电话、订单总金额字段
订单项（OrderItems）：有主键、订单ID、商品ID、定购数量、定购价格、金额
金额=定购数量*定购价格
订单总金额为该订单下的所有订单项的金额的和

使用触发器实现，但添加、删除订单项或修改订单项的数量时，通过触发器修改订单总金额

*/
drop table 订单表
go

create table 商品表(商品编号 int identity(1,1),商品名称 varchar(30),商品价格 decimal(18,2),库存 int );
create table 订单表(订单号 int identity(1,1),客户名 varchar(30),客户电话 varchar(20),订单总金额 decimal(18,2));
create table 订单项(明细编号 int identity(1,1),订单号 int,商品编号 int,定购数量 int ,定购价格 decimal(18,2),金额小计 decimal(18,2));
insert into 商品表 values('华为P10',5800,10);
insert into 商品表 values('华为P9',4800,10);
insert into 商品表 values('华为P8',3800,10);
insert into 商品表 values('IPhoneX',8800,5);
insert into 商品表 values('OPPO R11',8848,8);
truncate table 订单表;
truncate table 订单项;

select * from 商品表;
update 商品表 set 库存=10 where 商品编号=1;
select * from 订单表;
insert into 订单表 values('张三','13888888888',0);

select * from 订单项;

insert into 订单项  values(1,1,5,5800,5*5800);
insert into 订单项  values(1,2,5,4800,5*4800);
insert into 订单项  values(1,3,15,3800,15*3800);

update 订单项 set 定购数量=9,定购价格=5300,金额小计=9*5300 where 明细编号=1;
delete 订单项 where 明细编号=2;


delete 订单项 where 明细编号=1;

--新增触发器
create trigger tr_orderitem on 订单项 for insert

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodsprice decimal(18,2);
	select @orderid=订单号,@goodsid=商品编号,@goodscount=定购数量,@goodsprice=定购价格 from inserted;
	
	if(select 库存-@goodscount from 商品表 where 商品编号=@goodsid)>=0
	begin
		--更新库存		
		update 商品表 set 库存=库存-@goodscount where 商品编号=@goodsid;
		--更新订单总金额;
		update 订单表 set 订单总金额 = 订单总金额 + @goodscount*@goodsprice where 订单号=@orderid;
	end;
	else
	begin
		print '购买失败';
		rollback tran;
	end;
go

--新增触发器
create trigger tr_orderitemdel on 订单项 for delete

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodsprice decimal(18,2);
	select @orderid=订单号,@goodsid=商品编号,@goodscount=定购数量,@goodsprice=定购价格 from deleted;
	--更新库存		
	update 商品表 set 库存=库存+@goodscount where 商品编号=@goodsid;
	--更新订单总金额;
	update 订单表 set 订单总金额 = 订单总金额 - @goodscount*@goodsprice where 订单号=@orderid;
go
--修改
alter trigger tr_orderitemupdate on 订单项 for update

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodscount1 int; --保存修改前的数量
	declare @goodsprice decimal(18,2);

	select @goodscount1=定购数量 from deleted;
	select @orderid=订单号,@goodsid=商品编号,@goodscount=定购数量,@goodsprice=定购价格 from inserted;
	
	if(select 库存-(@goodscount-@goodscount1) from 商品表 where 商品编号=@goodsid)>=0
	begin
		--更新库存		
		update 商品表 set 库存=库存-(@goodscount-@goodscount1) where 商品编号=@goodsid;
		--更新订单总金额;
		update 订单表 set 订单总金额 = (select sum(金额小计) from  订单项 where 订单号=@orderid ) where 订单号=@orderid;
	end;
	else
	begin
		print '购买失败';
		rollback tran;
	end;
go

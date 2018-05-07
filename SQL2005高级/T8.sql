/*
	创建存储过程
	create procedure 存储过程的名称

		参数1 数据类型1,
		参数2 数据类型2,
		参数3 数据类型3,
		.....
		参数n 数据类型n output,

	as
		存储过程体

	go


*/

--查询所有的学生信息
--不带参数的存储过程
create procedure up_student

as
	select * from student;
go

--执行存储过程
up_student;
exec up_student;
execute up_student;
--删除存储过程
drop proc up_student;
--修改存储过程
alter procedure up_student

as
	select * from student;
go

--创建带参数的存储过程
alter procedure up_findStudentById
	--定义参数
	@age int,
	@classid int
as
	select * from student where 班级编号=@classid and 年龄=@age;
go
--执行带参数的存储过程,参数的顺序必须与定义的顺序一致，并且类型相同（兼容）
up_findStudentById 27,1;
--执行存储过程的时候，指明了参数的名称，可以与定义的参数顺序不一致
up_findStudentById @classid=1,@age=27;
up_findStudentById @age=27,@classid=1;

declare @age int;
declare @classid int;
set @age = 29;
set @classid = 2;
exec up_findStudentById @age,@classid

--定义含有输入，输出参数的存储过程

create procedure up_StatStudCnt
	--定义参数
	@age int,
	@classid int,
	--输出参数
	@cnt int output
as
	select @cnt=count(*) from student where 班级编号=@classid and 年龄=@age;
	--返回结果
	select @cnt;
go


--执行存储过程



declare @age int;
declare @classid int;
declare @cnt int;
set @age = 29;
set @classid = 2;
exec up_StatStudCnt @age,@classid,@cnt output
select @cnt;

/*
	第7章上机作业
	6.1.	图书销售系统的三个表：图书、订单、订单项，如下：
*/
drop table customer;
go
create table customer
(
	custname varchar(20) primary key,
	password varchar(20),
	balance decimal(18,2)
)
insert into customer values('张三','1234',10000);
insert into customer values('李四','1234',5000);
insert into customer values('小丽','1234',1000);
go
create table bookinfo
(
	bookid int identity(1,1) primary key,
	bookname varchar(50) not null,
	authorname varchar(30),
	price decimal(18,2),
	discount decimal(18,2),
	inventory int
)
insert into bookinfo values('JAVA','赖国荣',108,0.9,10);
insert into bookinfo values('JS','陈老师',58,0.9,100);
insert into bookinfo values('SQL2005','钟老师',88,0.9,30);
insert into bookinfo values('JSP','王老师',118,0.9,1);

go
create table orders
(
	orderid int identity(1,1) primary key,
	custname varchar(20),
	createtime datetime,
	status char(1)
)
insert into 
go
create table orderItem
(
	itemid int identity(1,1) primary key,
	orderid int references orders(orderid),
	bookid int references bookinfo(bookid),
	quantity int,
	price decimal(18,2)
)
/*
假设李四要购买10本Java、2本JSP，写一段代码保存该订单，参考步骤如下：
1.	启动事务
2.	保存订单记录
3.	保存订单项记录
4.	从客户的帐户中扣除所购买商品的金额，若金额不够，撤销前两步的操作
5.	扣除图书库存，若库存不够，撤销前面三步的操作
6.	提交事务

*/
update customer set balance=2000 where custname='李四';
update bookinfo set inventory=10 where bookid=1;
update bookinfo set inventory=5 where bookid=4;

truncate table orderitem;
delete orders;

select * from customer;
select * from bookinfo;
select * from orders;
select * from orderitem;
 
--创建存储过程
alter procedure up_buybook
	@custname varchar(20)
as
	declare @balance decimal(18,2);
	--获取客户余额
	select @balance=balance from customer where custname=@custname;
	--启动事务
	begin tran;
	declare @bookid int
	declare @price decimal(18,2);
	declare @discount decimal(18,2);
	declare @bookid1 int
	declare @price1 decimal(18,2);
	declare @discount1 decimal(18,2);
	select @bookid=bookid,@price=price,@discount=discount from bookinfo where bookid=1;
	select @bookid1=bookid,@price1=price,@discount1=discount from bookinfo where bookid=4;
	--新增订单
	declare @totalmoney decimal(18,2);
	set @totalmoney = @price*10*@discount+@price1*2*@discount1;
	insert into orders values(@custname,getdate(),'C');
	--查询订单号
	declare @orderid int;
	select @orderid = max(orderid) from orders;
	--新增订单项
	insert into orderitem values(@orderid,@bookid,10,@price*10*@discount);
	insert into orderitem values(@orderid,@bookid1,2,@price1*2*@discount1);
	--查看客户余额
	if((select balance from customer where custname=@custname)>=@totalmoney)
	begin
		update customer set balance=balance-@totalmoney where custname=@custname;
	end
	else
	begin
		print '余额不足，无法完成交易';
		rollback tran;
		return;
	end;
	--查看java库存
	if((select inventory from bookinfo where bookid=@bookid)>=10)
	begin
		--更新库存
		update bookinfo set inventory=inventory-10 where bookid=@bookid;
	end;
	else
	begin
		print 'java课程库存不足，交易失败';
		rollback tran;
		return;
	end;
	--查看jsp库存
	if((select inventory from bookinfo where bookid=@bookid1)>=2)
	begin
		--更新库存
		update bookinfo set inventory=inventory-2 where bookid=@bookid1;
	end;
	else
	begin
		print 'jsp课程库存不足，交易失败';
		rollback tran;
		return;
	end;
	commit tran;
go

--执行存储过程
up_buybook '李四';

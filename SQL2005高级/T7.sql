select * from sysmessages;

select * from sysmessages where error=208;


--创建balance表
create table balance
(
	userid int identity(1,1) primary key,
	username varchar(20) not null,
	remainMoney decimal(18,2)
)

insert into balance values('张三',10000);
insert into balance values('李四',20000);
select * from balance;

update balance set remainMoney=remainmoney-1000 where userid=1;
update balance set remainMoney=remainmoney+1000 where userid='aa';

--select @@error;

--事务处理

begin transaction --开始事务
declare @errornum int;
set @errornum=0;
update balance set remainMoney=remainmoney-1000 where userid=1;
update balance set remainMoney=remainmoney+1000 where userid='bb';
set @errornum =@errornum+@@error;
if @errornum>0
begin
	print '转账失败';
	rollback transaction; --回滚事务
end
else
begin
	print '转账成功';
	commit transaction --提交事务
end;

--确保2个更新语句要么都成功，要么都失败

begin try	--可能出现异常的语句块
	begin transaction --开始事务
	update balance set remainMoney=remainmoney-1000 where userid=1;
	update balance set remainMoney=remainmoney+1000 where userid='bb';
	commit transaction --提交事务
	print '转账成功';
end try
begin catch	--出现异常以后的处理
	print '转账失败';
	rollback transaction; --回滚事务
end catch









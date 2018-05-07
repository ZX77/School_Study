--5.1.	Ա������instert�����������Ա�����ظ������ܲ���
select * from emp;
alter table emp add joindate datetime;

update emp set joindate='2014-8-8' where empid=1;
update emp set joindate='2015-8-8' where empid=2;
update emp set joindate='2016-8-8' where empid=3;

alter trigger tr_empadd on emp for insert

as
	declare @empname varchar(20);
	--��ȡ����Ա����������
	select @empname=empname from inserted;
	--�������1����ͬ����Ա��
	if (select count(*) from emp where empname=@empname)>1 
	begin
		print '�Ѿ���������Ϊ��'+@empname+'����Ա��������ʧ��';
		--�ع�
		rollback tran;
	end

go

select * from emp;
insert into emp values('��С��','M',1800,'2014-3-1');

--5.2.	Ա������update�����������Ա����ְ���30���£����ʲ��ܵ���2000Ԫ
--�޸�һ��Ա������
create trigger tr_empupdate on emp for update

as
	declare @empid int;
	declare @month int;
	declare @salary int;
	select @empid=empid,@salary=salary,@month=(datediff(mm,joindate,getdate())) from inserted;
	if(@month>30 and @salary<2000)
	begin
		print '��Ա����ְ�Ѿ�����30���£���͹��ʲ��ܵ���2000���޸�ʧ��';
		rollback transaction;
	end;
go
update emp set salary=2600 where empid=6;
--�޸Ķ��Ա������


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
			print @empname+'��ְ�Ѿ�����30���£���͹��ʲ��ܵ���2000���޸�ʧ��';
			rollback transaction;
		end;
		fetch next from cur into @empname,@salary,@month;
	end;
	close cur;
	deallocate cur;
go

select * from emp;
insert into emp values('����','M',1800,'2013-3-1');
insert into emp values('����','M',1800,'2012-3-1');
insert into emp values('˵˵','M',1800,'2017-3-1');

update emp set salary=1700 where empid>9;

--5.3.	Ա�����д���delete��������δ��ְ��Ա������ɾ��
alter table emp add empstatus varchar(10);
update emp set empstatus='��ְ' where empid<=6;
update emp set empstatus='��ְ',salary=3000 where empid>6;
alter trigger tr_empdelete on emp for delete

as
	declare @empname varchar(20);
	declare @empstatus varchar(10);
	select @empname=empname,@empstatus=empstatus from deleted;
	if @empstatus='��ְ'
	begin
		print @empname+'û����ְ������ɾ����ְԱ����ɾ��ʧ��';
		rollback tran;
	end;
go

delete emp where empid=10;

/*
6.2.	��������
��Ʒ��Product��������������Ʒ���ơ���Ʒ�۸񡢿���ֶ�
������Orders)�������������š��ͻ������ͻ��绰�������ܽ���ֶ�
�����OrderItems����������������ID����ƷID�����������������۸񡢽��
���=��������*�����۸�
�����ܽ��Ϊ�ö����µ����ж�����Ľ��ĺ�

ʹ�ô�����ʵ�֣�����ӡ�ɾ����������޸Ķ����������ʱ��ͨ���������޸Ķ����ܽ��

*/
drop table ������
go

create table ��Ʒ��(��Ʒ��� int identity(1,1),��Ʒ���� varchar(30),��Ʒ�۸� decimal(18,2),��� int );
create table ������(������ int identity(1,1),�ͻ��� varchar(30),�ͻ��绰 varchar(20),�����ܽ�� decimal(18,2));
create table ������(��ϸ��� int identity(1,1),������ int,��Ʒ��� int,�������� int ,�����۸� decimal(18,2),���С�� decimal(18,2));
insert into ��Ʒ�� values('��ΪP10',5800,10);
insert into ��Ʒ�� values('��ΪP9',4800,10);
insert into ��Ʒ�� values('��ΪP8',3800,10);
insert into ��Ʒ�� values('IPhoneX',8800,5);
insert into ��Ʒ�� values('OPPO R11',8848,8);
truncate table ������;
truncate table ������;

select * from ��Ʒ��;
update ��Ʒ�� set ���=10 where ��Ʒ���=1;
select * from ������;
insert into ������ values('����','13888888888',0);

select * from ������;

insert into ������  values(1,1,5,5800,5*5800);
insert into ������  values(1,2,5,4800,5*4800);
insert into ������  values(1,3,15,3800,15*3800);

update ������ set ��������=9,�����۸�=5300,���С��=9*5300 where ��ϸ���=1;
delete ������ where ��ϸ���=2;


delete ������ where ��ϸ���=1;

--����������
create trigger tr_orderitem on ������ for insert

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodsprice decimal(18,2);
	select @orderid=������,@goodsid=��Ʒ���,@goodscount=��������,@goodsprice=�����۸� from inserted;
	
	if(select ���-@goodscount from ��Ʒ�� where ��Ʒ���=@goodsid)>=0
	begin
		--���¿��		
		update ��Ʒ�� set ���=���-@goodscount where ��Ʒ���=@goodsid;
		--���¶����ܽ��;
		update ������ set �����ܽ�� = �����ܽ�� + @goodscount*@goodsprice where ������=@orderid;
	end;
	else
	begin
		print '����ʧ��';
		rollback tran;
	end;
go

--����������
create trigger tr_orderitemdel on ������ for delete

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodsprice decimal(18,2);
	select @orderid=������,@goodsid=��Ʒ���,@goodscount=��������,@goodsprice=�����۸� from deleted;
	--���¿��		
	update ��Ʒ�� set ���=���+@goodscount where ��Ʒ���=@goodsid;
	--���¶����ܽ��;
	update ������ set �����ܽ�� = �����ܽ�� - @goodscount*@goodsprice where ������=@orderid;
go
--�޸�
alter trigger tr_orderitemupdate on ������ for update

as
	declare @orderid int;
	declare @goodsid int;
	declare @goodscount int;
	declare @goodscount1 int; --�����޸�ǰ������
	declare @goodsprice decimal(18,2);

	select @goodscount1=�������� from deleted;
	select @orderid=������,@goodsid=��Ʒ���,@goodscount=��������,@goodsprice=�����۸� from inserted;
	
	if(select ���-(@goodscount-@goodscount1) from ��Ʒ�� where ��Ʒ���=@goodsid)>=0
	begin
		--���¿��		
		update ��Ʒ�� set ���=���-(@goodscount-@goodscount1) where ��Ʒ���=@goodsid;
		--���¶����ܽ��;
		update ������ set �����ܽ�� = (select sum(���С��) from  ������ where ������=@orderid ) where ������=@orderid;
	end;
	else
	begin
		print '����ʧ��';
		rollback tran;
	end;
go

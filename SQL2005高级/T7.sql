select * from sysmessages;

select * from sysmessages where error=208;


--����balance��
create table balance
(
	userid int identity(1,1) primary key,
	username varchar(20) not null,
	remainMoney decimal(18,2)
)

insert into balance values('����',10000);
insert into balance values('����',20000);
select * from balance;

update balance set remainMoney=remainmoney-1000 where userid=1;
update balance set remainMoney=remainmoney+1000 where userid='aa';

--select @@error;

--������

begin transaction --��ʼ����
declare @errornum int;
set @errornum=0;
update balance set remainMoney=remainmoney-1000 where userid=1;
update balance set remainMoney=remainmoney+1000 where userid='bb';
set @errornum =@errornum+@@error;
if @errornum>0
begin
	print 'ת��ʧ��';
	rollback transaction; --�ع�����
end
else
begin
	print 'ת�˳ɹ�';
	commit transaction --�ύ����
end;

--ȷ��2���������Ҫô���ɹ���Ҫô��ʧ��

begin try	--���ܳ����쳣������
	begin transaction --��ʼ����
	update balance set remainMoney=remainmoney-1000 where userid=1;
	update balance set remainMoney=remainmoney+1000 where userid='bb';
	commit transaction --�ύ����
	print 'ת�˳ɹ�';
end try
begin catch	--�����쳣�Ժ�Ĵ���
	print 'ת��ʧ��';
	rollback transaction; --�ع�����
end catch









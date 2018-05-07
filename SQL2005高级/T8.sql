/*
	�����洢����
	create procedure �洢���̵�����

		����1 ��������1,
		����2 ��������2,
		����3 ��������3,
		.....
		����n ��������n output,

	as
		�洢������

	go


*/

--��ѯ���е�ѧ����Ϣ
--���������Ĵ洢����
create procedure up_student

as
	select * from student;
go

--ִ�д洢����
up_student;
exec up_student;
execute up_student;
--ɾ���洢����
drop proc up_student;
--�޸Ĵ洢����
alter procedure up_student

as
	select * from student;
go

--�����������Ĵ洢����
alter procedure up_findStudentById
	--�������
	@age int,
	@classid int
as
	select * from student where �༶���=@classid and ����=@age;
go
--ִ�д������Ĵ洢����,������˳������붨���˳��һ�£�����������ͬ�����ݣ�
up_findStudentById 27,1;
--ִ�д洢���̵�ʱ��ָ���˲��������ƣ������붨��Ĳ���˳��һ��
up_findStudentById @classid=1,@age=27;
up_findStudentById @age=27,@classid=1;

declare @age int;
declare @classid int;
set @age = 29;
set @classid = 2;
exec up_findStudentById @age,@classid

--���庬�����룬��������Ĵ洢����

create procedure up_StatStudCnt
	--�������
	@age int,
	@classid int,
	--�������
	@cnt int output
as
	select @cnt=count(*) from student where �༶���=@classid and ����=@age;
	--���ؽ��
	select @cnt;
go


--ִ�д洢����



declare @age int;
declare @classid int;
declare @cnt int;
set @age = 29;
set @classid = 2;
exec up_StatStudCnt @age,@classid,@cnt output
select @cnt;

/*
	��7���ϻ���ҵ
	6.1.	ͼ������ϵͳ��������ͼ�顢��������������£�
*/
drop table customer;
go
create table customer
(
	custname varchar(20) primary key,
	password varchar(20),
	balance decimal(18,2)
)
insert into customer values('����','1234',10000);
insert into customer values('����','1234',5000);
insert into customer values('С��','1234',1000);
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
insert into bookinfo values('JAVA','������',108,0.9,10);
insert into bookinfo values('JS','����ʦ',58,0.9,100);
insert into bookinfo values('SQL2005','����ʦ',88,0.9,30);
insert into bookinfo values('JSP','����ʦ',118,0.9,1);

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
��������Ҫ����10��Java��2��JSP��дһ�δ��뱣��ö������ο��������£�
1.	��������
2.	���涩����¼
3.	���涩�����¼
4.	�ӿͻ����ʻ��п۳���������Ʒ�Ľ�������������ǰ�����Ĳ���
5.	�۳�ͼ���棬����治��������ǰ�������Ĳ���
6.	�ύ����

*/
update customer set balance=2000 where custname='����';
update bookinfo set inventory=10 where bookid=1;
update bookinfo set inventory=5 where bookid=4;

truncate table orderitem;
delete orders;

select * from customer;
select * from bookinfo;
select * from orders;
select * from orderitem;
 
--�����洢����
alter procedure up_buybook
	@custname varchar(20)
as
	declare @balance decimal(18,2);
	--��ȡ�ͻ����
	select @balance=balance from customer where custname=@custname;
	--��������
	begin tran;
	declare @bookid int
	declare @price decimal(18,2);
	declare @discount decimal(18,2);
	declare @bookid1 int
	declare @price1 decimal(18,2);
	declare @discount1 decimal(18,2);
	select @bookid=bookid,@price=price,@discount=discount from bookinfo where bookid=1;
	select @bookid1=bookid,@price1=price,@discount1=discount from bookinfo where bookid=4;
	--��������
	declare @totalmoney decimal(18,2);
	set @totalmoney = @price*10*@discount+@price1*2*@discount1;
	insert into orders values(@custname,getdate(),'C');
	--��ѯ������
	declare @orderid int;
	select @orderid = max(orderid) from orders;
	--����������
	insert into orderitem values(@orderid,@bookid,10,@price*10*@discount);
	insert into orderitem values(@orderid,@bookid1,2,@price1*2*@discount1);
	--�鿴�ͻ����
	if((select balance from customer where custname=@custname)>=@totalmoney)
	begin
		update customer set balance=balance-@totalmoney where custname=@custname;
	end
	else
	begin
		print '���㣬�޷���ɽ���';
		rollback tran;
		return;
	end;
	--�鿴java���
	if((select inventory from bookinfo where bookid=@bookid)>=10)
	begin
		--���¿��
		update bookinfo set inventory=inventory-10 where bookid=@bookid;
	end;
	else
	begin
		print 'java�γ̿�治�㣬����ʧ��';
		rollback tran;
		return;
	end;
	--�鿴jsp���
	if((select inventory from bookinfo where bookid=@bookid1)>=2)
	begin
		--���¿��
		update bookinfo set inventory=inventory-2 where bookid=@bookid1;
	end;
	else
	begin
		print 'jsp�γ̿�治�㣬����ʧ��';
		rollback tran;
		return;
	end;
	commit tran;
go

--ִ�д洢����
up_buybook '����';

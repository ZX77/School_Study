--����ע��
/*
	����ע��
*/
--�����ݿ���������@@��ͷ�ı�������ϵͳ��ȫ�ֱ������Զ���ı���ֻ����@��ͷ�������ֲ��������û�ֻ�ܶ���ֲ�����
--�������һ��ִ��SQL���������������Ľ��
select @@ERROR;
--����Ĭ�ϵ�����
select @@language;
--���ط�����������
select @@servername;
--���ط�����
select @@servicename;
--���ذ汾��
select @@version;

/*
	�Զ���������ֲ���������
	1.�Զ������������һ��@���ſ�ͷ��

	�﷨��
	declare @��������	��������;


*/
	--�������
	declare @username varchar(50);
	--set����������ֵ
	set @username='admin';
	--�鿴������ֵ
	select @username;
	--select����������ֵ
	select @username='����';
	select @username;
	go
	declare @str varchar(50);
	set @str='administrator';
	select left(@str,5),substring(@str,1,5);
	go
	declare @age int;
	set @age = 18;
	select @age;

	go

declare @studid int;
declare @studname varchar(50);
declare @cardno varchar(18);
declare @sex varchar(2);
declare @age int;
declare @postcode varchar(6);
declare @begindate datetime;
declare @classid int;
select @studid=ѧ��,@studname=����,@cardno=���֤��,@sex=�Ա�,@age=����,@postcode=��������,@begindate=��ѧʱ��,@classid=�༶��� from student where ѧ��=6;
select @studid,@studname,@cardno,@sex,@age,@postcode,@begindate,@classid;
if @age>18 
begin
	print '���Ѿ��ǳ����ˣ�Ҫ��������˵�����';
end;
else if @age>=60
begin
	print '���Ѿ��Ǹ��������ˣ�ѧϰ����ôŬ��';
end;
else
begin
	print '�����ú��ӣ��ú�ѧϰ����������';
end;





--�л���ǰ���ݿ�
use qq2016;
use test;
if (select count(*) from student where ѧ��=10)>0
begin
	print '����ѧ������';
end;
else
begin
	print 'û�и�ѧ����ѧ������';
end;
go

--whileѭ�����
--��1+2+3+...100�ĺ�

declare @sum int;
declare @i int;
set @i=1;
set @sum=0;
while @i<=100
begin
	set @sum=@sum+@i;
	set @i=@i+1;
end;
print @sum;

--��1+3+5...99�����ĺ�

declare @sum int;
declare @i int;
set @i=1;
set @sum=0;
while @i<=100
begin
	set @sum=@sum+@i;
	set @i=@i+2;
end;
print @sum;


declare @sum int;
declare @i int;
set @i=0;
set @sum=0;
while @i<=100
begin
	set @i=@i+1;
	if @i>99
	begin
		break;
	end;
	if (@i % 2)= 0
	begin
		continue;
	end;
	set @sum=@sum+@i;
end;
print @sum;

--case����൱��java��switch���

select s.ѧ��,����,�ɼ�,
case 
when �ɼ�<60 then '������'  
when �ɼ�>=60 and �ɼ�<70 then '����'
when �ɼ�>=70 and �ɼ�<80 then '����'
when �ɼ�>=80 then '����'
end �ȼ�
from �ɼ��� c 
inner join student s on c.ѧ��=s.ѧ��
inner join �γ̱� k on k.�γ̺�=c.�γ̺�;



select ѧ��,����,���֤��,�Ա�,
case �༶���
when 1 then '2017��ͼ1��'
when 2 then '2017��ͼ2��'
when 3 then '2017��ͼ3��'
end �༶����
  from student;


--waitfor�ȴ���ָ��ʱ��󣬼�����������

--�ȴ�10�����Ժ��������ִ��
waitfor delay '00:00:10';
select * from student;

--�ȴ���ָ����ʱ���Ժ��������ִ��
waitfor time '10:13:10';
select * from student;

--������

set xact_abort on;
begin try
	--��ʼ����
	begin transaction
	insert into student values(7,'aaa','362101198808081111','��',22,'341000',getdate(),3);
	--�ύ����
	commit transaction
	print '�����ɹ�';

end try
begin catch
	--�ع�����
	rollback tran;
	print '����ʧ��';
end catch

























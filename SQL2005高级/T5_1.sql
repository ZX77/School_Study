select * from student;

--5.	������ϰ
--1.	��ѯ������Ա����sexΪM����ʾ�ɡ��С�,F��ʾ��Ů

select *,case �Ա� when '��' then 'M' when 'Ů' then 'F' end �Ա�1 from student;

--2.	ѭ��������Ա���Ĺ�����10%��ֱ����߹�������͹��ʵ�����Ϊֹ
create table emp (empid int identity(1,1) primary key,empName varchar(20),sex char(1),salary decimal(18,2));

insert into emp values('����','M',2000);
insert into emp values('С��','F',1800);
insert into emp values('����','M',2400);
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

--3.	дһ��T-SQL����1-100��Щ��ͬʱ��3��7����

declare @i int;
set @i=1;
while @i<=100
begin
	if(@i%3=0 and @i %7=0)
	begin
		print cast(@i as varchar(3)) +'��ͬʱ��3��7����'
	end;
	set @i=@i+1;
end;

--4.	ʹ��switch case дһ�����ӣ����ݲ�ͬ��ʱ�����ж����磬���磬����

declare @hour int;
select @hour=datepart(hh,getdate());
select  case 
when @hour>0 and @hour<8 then '����'
when @hour>=8 and @hour<12 then '����'
when @hour>=12 and @hour<14 then '����'
when @hour>=14 and @hour<18 then '����'
else '����' end

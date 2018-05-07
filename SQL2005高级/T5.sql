--单行注释
/*
	多行注释
*/
--在数据库中所有已@@开头的变量就是系统的全局变量，自定义的变量只能用@开头，叫做局部变量，用户只能定义局部变量
--返回最后一次执行SQL语句或者批处理语句的结果
select @@ERROR;
--返回默认的语言
select @@language;
--返回服务器的名称
select @@servername;
--返回服务名
select @@servicename;
--返回版本号
select @@version;

/*
	自定义变量（局部变量）：
	1.自定义变量必须以一个@符号开头；

	语法：
	declare @变量名称	数据类型;


*/
	--定义变量
	declare @username varchar(50);
	--set语句给变量赋值
	set @username='admin';
	--查看变量的值
	select @username;
	--select语句给变量赋值
	select @username='张三';
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
select @studid=学号,@studname=姓名,@cardno=身份证号,@sex=性别,@age=年龄,@postcode=邮政编码,@begindate=入学时间,@classid=班级编号 from student where 学号=6;
select @studid,@studname,@cardno,@sex,@age,@postcode,@begindate,@classid;
if @age>18 
begin
	print '你已经是成年人，要负起成年人的责任';
end;
else if @age>=60
begin
	print '你已经是个老年人了，学习还这么努力';
end;
else
begin
	print '做个好孩子，好好学习，天天向上';
end;





--切换当前数据库
use qq2016;
use test;
if (select count(*) from student where 学号=10)>0
begin
	print '存在学生资料';
end;
else
begin
	print '没有该学生的学籍资料';
end;
go

--while循环语句
--求1+2+3+...100的和

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

--求1+3+5...99奇数的和

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

--case语句相当于java的switch语句

select s.学号,姓名,成绩,
case 
when 成绩<60 then '不及格'  
when 成绩>=60 and 成绩<70 then '及格'
when 成绩>=70 and 成绩<80 then '良好'
when 成绩>=80 then '优秀'
end 等级
from 成绩表 c 
inner join student s on c.学号=s.学号
inner join 课程表 k on k.课程号=c.课程号;



select 学号,姓名,身份证号,性别,
case 班级编号
when 1 then '2017宏图1班'
when 2 then '2017宏图2班'
when 3 then '2017宏图3班'
end 班级名称
  from student;


--waitfor等待到指定时间后，继续往下运行

--等待10秒钟以后继续往下执行
waitfor delay '00:00:10';
select * from student;

--等待到指定的时间以后继续往下执行
waitfor time '10:13:10';
select * from student;

--事务处理

set xact_abort on;
begin try
	--开始事务
	begin transaction
	insert into student values(7,'aaa','362101198808081111','男',22,'341000',getdate(),3);
	--提交事务
	commit transaction
	print '新增成功';

end try
begin catch
	--回滚事务
	rollback tran;
	print '新增失败';
end catch

























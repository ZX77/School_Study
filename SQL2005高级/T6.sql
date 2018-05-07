SELECT * FROM STUDENT;

/*
定义游标

	declare 游标的名称 cursor for 查询语句 for read only | update of 字段列表

	1.游标使用完后必须关闭，否则下次就使用不了；
*/

--1.定义只进游标
declare cur cursor forward_only for select * from student;
--2.打开游标
open cur;
--3.提取当前行的值
fetch next from cur;
--只进游标只能使用next
--fetch first from cur;
--4.关闭游标
close cur;
--5.释放游标
deallocate cur;


--1.定义滚动游标
declare cur cursor scroll for select * from student;
--2.打开游标
open cur;
--3.提取当前行的值
fetch next from cur;
--第一条
fetch first from cur;
--最后一条
fetch last from cur;
--上一条
fetch prior from cur;
--绝对定位
fetch absolute 3 from cur;
--相对定位
fetch relative 2 from cur;
fetch relative -3 from cur;
--4.关闭游标
close cur;
--5.释放游标
deallocate cur;


-----------------------------------

/*游标状态
	@@FETCH_STATUS=0获取数据成功,
	@@FETCH_STATUS=-1获取数据失败,
	@@FETCH_STATUS=-2获取数据失败,
*/

declare cur cursor for select * from student;
open cur;
fetch next from cur;
while @@FETCH_STATUS=0
begin
	fetch next from cur;
end;
close cur;
deallocate cur;
-----------------------------------------
/*
	查询列表中有几个字段，就必须定义几个对应的变量
*/
declare @studid int;
declare @studname varchar(20);
declare @cardno varchar(18);
declare @sex varchar(2);
declare @age int;
declare @postcode int;
declare @indate datetime;
declare @classid int;
declare @temp int;
declare cur cursor for select * from student for read only;
open cur;
fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
while @@FETCH_STATUS=0
begin
	--获取身份证的年
	set @temp = cast(substring(@cardno,7,4) as int);
	set @age = year(getdate())-@temp;
	--update student set 年龄=@age where 学号=@studid;
	update student set 年龄=@age where current of cur; --current of cur代表当前行
	fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
end;
close cur;
deallocate cur;
-----------------------------------------------
declare @studid int;
declare @studname varchar(20);
declare @cardno varchar(18);
declare @sex varchar(2);
declare @age int;
declare @postcode int;
declare @indate datetime;
declare @classid int;
declare @temp int;
declare cur cursor for select * from student for update of 年龄;--控制可以更新的列
open cur;
select @@cursor_rows
fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
while @@FETCH_STATUS=0
begin
	--获取身份证的年
	set @temp = cast(substring(@cardno,7,4) as int);
	set @age = year(getdate())-@temp;
	update student set 年龄=@age where current of cur; --current of cur代表当前行
	fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
end;
close cur;
deallocate cur;


select * from student;

------------------------------------------------------
--定义静态游标
--只有定义静态游标时，@@cursor_rows变量返回的值才有意义，dynamic游标返回-1，默认游标就是动态的只进游标
declare cur cursor static for select * from student;--控制可以更新的列
open cur;
select @@cursor_rows
fetch next from cur;
while @@FETCH_STATUS=0
begin
	fetch next from cur;
end;
close cur;
deallocate cur;

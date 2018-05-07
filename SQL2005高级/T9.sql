/*
	触发器：是一种特殊的存储过程，是属于表的
		1.一个表只有3中触发器，删除，修改，新增
		2.不能在临时表，系统表上创建触发器；
		3.可以在触发器中引用临时表，但是不能引用系统表
		4.一个触发器中可以同时触发多个事件;
	2个逻辑表：这2个逻辑表只能在触发器中使用，其他情况都不能使用(不存在)
		1.inserted表：存放由于新增或者修改向表中插入的所有行；
		2.deleted表：存放由于删除或者修改，从表中删除的所有行		


*/

select * from student;
--创建触发器，学生年龄小于10岁时不能新增到学生表中

create trigger tr_checkAge on student for insert

as 
	--inserted逻辑表与student表结构是一致的，里面只有新增的记录数据
	if (select 年龄 from inserted)<10
	begin
		print '年龄太小，不适合学习软件开发专业';
		--回滚事务
		rollback transaction;
	end;
go

 insert into student values(8,'吖吖','362101198808081166','男',9,'341000',getdate(),2);
 insert into student values(9,'吖吖','362101198808081166','男',19,'341000',getdate(),2);

select * from classes;
alter table classes add 班级人数 int;

update classes set 班级人数=0;

alter trigger tr_modifycnt on student for insert

as 
	declare @classid int;
	select @classid=班级编号 from inserted ;
	--更新班级表中该班的人数
	--update classes set 班级人数=(select count(*) from student where 班级编号=@classid) where 班级编号=@classid;
	update classes set 班级人数=班级人数+1 where 班级编号=@classid;
go

 insert into student values(10,'叶问','362101198808081168','男',19,'341000',getdate(),1);
 insert into student values(11,'叶问2','362101198808081169','男',19,'341000',getdate(),2);
 insert into student values(12,'叶问4','362101198808081170','男',19,'341000',getdate(),3);
select * from classes;
select * from student order by 班级编号;
--删除学生信息时，同时更新班级表的人数
alter trigger tr_deletecnt on student for delete
as 
	declare @classid int;
	select @classid=班级编号 from deleted ;
	--更新班级表中该班的人数
	update classes set 班级人数=班级人数-1 where 班级编号=@classid;
	
go
delete student where 学号=4;
select * from 成绩表;
--修改学生信息时，同时更新班级表的人数
alter trigger tr_updatecnt on student for update
as 
	declare @classid int;
	--如果班级编号字段的值发生了变化就更新，否则不执行
	if update(班级编号)
	begin 
		select @classid=班级编号 from deleted ;
		--更新班级表中该班的人数
		update classes set 班级人数=班级人数-1 where 班级编号=@classid;
		select @classid=班级编号 from inserted ;
		--更新班级表中该班的人数
		update classes set 班级人数=班级人数+1 where 班级编号=@classid;
	end
go

update student set 年龄=20 where 学号=10;
--查看触发器
select * from sys.triggers;
select * from sys.trigger_events;
--禁用触发器
disable trigger tr_modifycnt  on student;
--启用触发器
enable trigger tr_modifycnt  on student;


insert into student values(14,'叶问6','362101198808081172','男',19,'341000',getdate(),3);
select * from classes;
select * from student order by 班级编号;
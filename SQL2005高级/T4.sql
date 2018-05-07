--视图语法
/*
	create view 视图名称

	as

		查询语句
		注意事项：
			1.视图中不能使用order by语句;
			2如果视图中有with check option ，那么在对视图做新增，修改，删除时都必须符合视图的条件，才能操作成功

*/

select * from student;

--创建视图
create view vstudent as select * from student;
--访问视图
select * from vstudent;
--修改视图
alter view vstudent as select distinct 性别 from student;
--删除视图
drop view vstudent;
create view vstudent as select distinct 性别 from student;
create view vstudent as select 性别,count(*) 人数 from student group by 性别;
--视图可以筛选数据
create view vstudent as select 学号,姓名,身份证号,性别 from student where 班级编号=2;


select * from vstudent where 性别='男';
--在视图中新增记录
insert into vstudent values(7,'小小','361001199008081132','女');
--修改视图数据
update vstudent set 性别='女' where  学号=3;
--删除视图中的数据
delete vstudent where 学号=7;

select * from student
update student set 班级编号=2 where 学号=7;

create view vstudent2 as select * from student where 班级编号=2 and 年龄<30 with check option;

select * from vstudent2;
--修改数据
update vstudent2 set 年龄=29 where 学号=3;

insert into vstudent2 values(7,'小小','361001199008081132','女',21,'341000',getdate(),2);
drop view vstudent2
--加密视图
create view vstudent2 WITH ENCRYPTION as select * from student where 班级编号=2 and 年龄<30 ;


--存储过程创建登录
exec sp_addlogin 'abc123','abc';
--删除登录
sp_droplogin 'abc123';

--通过命令创建登录
create login abc456 with password='123456';
--创建用户
create user abc456 for login abc456;










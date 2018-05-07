select * from classes;
select * from 课程表;
select * from student;
--使用系统存储过程窗口表结构及各种约束
sp_help student;

select * from 成绩表;
delete 成绩表 where 学号>4;


--创建组合键
alter table 成绩表 add constraint pk_score primary key(学号,课程号);
--与学生表创建外键
alter table 成绩表 add constraint FK_SCORE_STUDENT foreign key(学号) references student(学号);
alter table 成绩表 add constraint FK_SCORE_COURSE foreign key(课程号) references 课程表(课程号);




select * from classes;
select * from 课程表;
select * from student;
select * from 成绩表 order by 课程号;


--5.1.	查询所有学生的姓名、学号及班级名称
--5.2.	查询所有学生各门课程的成绩，列出姓名、班级名、课程名、成绩
select 姓名,班级名称,课程名,成绩 from 成绩表 c 
inner join 课程表 k on c.课程号=k.课程号
inner join student x on x.学号=c.学号
inner join classes b on b.班级编号=x.班级编号

select 姓名,班级名称,课程名,成绩 from 成绩表 c, 课程表 k,student x,classes b
where c.课程号=k.课程号 and x.学号=c.学号 and b.班级编号=x.班级编号;

select 姓名,班级名称,课程名,成绩 from 成绩表 c 
left join 课程表 k on c.课程号=k.课程号
left join student x on x.学号=c.学号
left join classes b on b.班级编号=x.班级编号

--5.3.	分别使用子查询和连接查询实现：查询ST0801班的C语言平均成绩
--round四舍五入，精确到小数位后的2位
select round(avg(成绩),2) from 成绩表 
where 学号 in(select 学号 from student where 班级编号=(select 班级编号 from classes where 班级名称='宏图201702班'))
and 课程号=(select 课程号 from 课程表 where 课程名='C语言')

select round(avg(成绩),2) from 成绩表 c
inner join 课程表 k on c.课程号=k.课程号
inner join student x on x.学号=c.学号
inner join classes b on b.班级编号=x.班级编号
where 班级名称='宏图201702班' and 课程名='C语言'

--5.4.	查询所有C语言成绩比其所在班级平均成绩高的学生

select x.*,c.成绩 from 成绩表 c
inner join 课程表 k on c.课程号=k.课程号
inner join student x on x.学号=c.学号
inner join classes b on b.班级编号=x.班级编号
where 班级名称='宏图201702班' and 课程名='C语言' and c.成绩>(
select round(avg(成绩),2) from 成绩表 
where 学号 in(select 学号 from student where 班级编号=(select 班级编号 from classes where 班级名称='宏图201702班'))
and 课程号=(select 课程号 from 课程表 where 课程名='C语言')
)

--5.5.	查找C语言没有成绩的所有学生的信息（使用exists实现）

select * from student s 
where not exists(select * from 成绩表 where 课程号=(select 课程号 from 课程表 where 课程名='数据库' and s.学号=学号))


--5.6.	使用SQL将ST0801班的所有学生的信息插入到一个新表StudentST0801中
drop table StudentST0801;
select * into StudentST0801 from student where 班级编号=(select 班级编号 from classes where 班级名称='宏图201702班')
select * from StudentST0801;
delete StudentST0801 where 学号>2;


--5.7.	查询在Student表中存在，但在StudentST0801表中不存在的学生
select * from student where 学号 not in(select 学号 from StudentST0801);

--5.8.	删除Student200801班的所有学生
delete StudentST0801 where 学号 in(select 学号 from classes where 班级名称='宏图201702班')

delete
truncate
drop 



--5.9.	查询Classes表和StudentST0801表的所有学生合到一个结果集中
select * from student s inner join classes c on s.班级编号=c.班级编号;

--6.1.	用一条SQL语句 查询出每门课都大于80分的学生姓名 分别使用连接查询和子查询实现

	select 姓名 from student where 学号 in(select 学号 from 成绩表 group by 学号 having min(成绩)>80);

	select * from 成绩表;

--6.2.	查询出所有同名的学生，列出姓名、班级
select * from student;
insert into student values(5,'张三','361001199008081123','男',88,341000,getdate(),1);
insert into student values(6,'老王','361001199008081124','男',28,341000,getdate(),1);

select 姓名,班级名称 from student s inner join classes c on c.班级编号=s.班级编号
where 姓名 in (select 姓名 from student group by 姓名 having count(姓名)>1);

--6.3.	假设每个学生每门课程都应该有成绩，查询出没有成绩的学生及其课程，列出姓名、班级名、课程

select 学号,姓名,课程名 from student s cross join 课程表 k 
where not exists(select * from 成绩表 where 学号=s.学号 and 课程号=k.课程号);


--6.4.	查询得出以下结果：
select * from 课程表
--isnull（返回值，默认值）函数

select 姓名,
isnull((select 成绩 from 成绩表 where 学号=s.学号 and 课程号=1),0) HTML,
isnull((select 成绩 from 成绩表 where 学号=s.学号 and 课程号=2),0) C语言,
isnull((select 成绩 from 成绩表 where 学号=s.学号 and 课程号=3),0) 数据库
 from student s ;



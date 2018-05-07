--日期函数
--GETDATE获取系统当前时间
select getdate();
--dateadd函数：对日期进行加减
--参数1：增量单位;参数2：增量值，参数3：日期类型的初始值

select dateadd(yyyy,1,getdate()) 增加1年,dateadd(qq,1,getdate()) 增加1个季度,dateadd(mm,1,getdate()) 增加1月,dateadd(dd,11,getdate()) 增加11天;

select dateadd(wk,1,getdate()) 增加1星期,dateadd(hh,1,getdate()) 增加1小时,dateadd(mi,1,getdate()) 增加1分钟,dateadd(ss,1,getdate()) 增加1秒;

select dateadd(yyyy,-1,getdate()) 前1年,dateadd(qq,-1,getdate()) 前1个季度,dateadd(mm,-1,getdate()) 前1月,dateadd(dd,-11,getdate()) 前11天;

--datediff日期比较
select datediff(yyyy,'2017-11-1',getdate()) 相差年,datediff(mm,'2017-11-1',getdate()) 相差月份,datediff(dd,'2017-11-1',getdate()) 相差天数;
--datepart函数：获取日期的一部分
select datepart(yyyy,getdate()) 年,datepart(mm,getdate())月,datepart(dd,getdate()) 日,datepart(qq,getdate()) 季度,datepart(wk,getdate()) 一年中的第几个星期;

--0代表1900-1-1 00:00:00
--通过日期函数运算，显示2018年的第一天的时间
select dateadd(yyyy,datediff(yyyy,0,getdate())+1,0) '2018年的第一天';
select dateadd(yyyy,118,0)
select year(getdate()),month(getdate()),day(getdate());

select * from 成绩表 order by 成绩 desc;


select 姓名,课程名,成绩,rank() over (order by 成绩 desc) 成绩排名 from 成绩表 c 
inner join student s on c.学号=s.学号
inner join 课程表 k on c.课程号=k.课程号


select 姓名,课程名,成绩,dense_rank() over (order by 成绩 desc) 成绩排名 from 成绩表 c 
inner join student s on c.学号=s.学号
inner join 课程表 k on c.课程号=k.课程号

--数学函数

select cos(pi()) ,sin(pi()/2),abs(-100),rand() 随机数,pi() 圆周率,ceiling(8.01) 返回大于等于当前数的最小整数;
select ceiling(-9.9) 返回大于等于当前数的最小整数,round(8.888888,2) 四舍五入保留2位小数;
--e=2.718.....
select sqrt(9) 开平方,square(9) 平方,log(10) 以e为底数,log10(100) 以10为底数,power(9,3) '9的3次方';

--字符串函数
select ascii(9) 字符转ascii,char(56) ascii转字符,len('admin') 字符串长度,substring('abcdefg',2,3) 求字串;
select substring('abcdefg',2,3) 求字串,left('abcdefg',3) 前3个字符,right('abcdefg',3) 后3个字符
select ltrim('             abcdefghijkl       '),rtrim('             abcdefghijkl       '),ltrim(rtrim('             abcdefghijkl       '));
select charindex('d','abcdefg') 字符在字符串中的索引,lower('ABCDefG') 大写转小写,upper('abcdEFg') 小写转大写;
--convert类型转换函数
select (convert(varchar(4),year(getdate()))+'-'+convert(varchar(2),month(getdate()))+'-'+convert(varchar(2),day(getdate()))) 当前日期;
--cast类型转换函数
select (cast(year(getdate()) as varchar(4))+'-'+cast(month(getdate()) as varchar(2))+'-'+cast(day(getdate()) as varchar(20))) 当前日期;


--系统索引表
select * from sysindexes where indid=1;
--创建索引
--主键也是索引，是集聚索引，一个表只能有一个集聚索引
select * from student;
--创建普通索引
create index idx_classid on student(班级编号);
--创建唯一索引
create unique index idx_cardno2 on student(身份证号);
--删除索引
drop index idx_classid on student;
drop index idx_cardno2 on student;

sp_help student;
--查看表索引
sp_helpindex student;
--查询时可以指定索引
select * from student with(index=un_cardno);























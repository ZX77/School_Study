--���ں���
--GETDATE��ȡϵͳ��ǰʱ��
select getdate();
--dateadd�����������ڽ��мӼ�
--����1��������λ;����2������ֵ������3���������͵ĳ�ʼֵ

select dateadd(yyyy,1,getdate()) ����1��,dateadd(qq,1,getdate()) ����1������,dateadd(mm,1,getdate()) ����1��,dateadd(dd,11,getdate()) ����11��;

select dateadd(wk,1,getdate()) ����1����,dateadd(hh,1,getdate()) ����1Сʱ,dateadd(mi,1,getdate()) ����1����,dateadd(ss,1,getdate()) ����1��;

select dateadd(yyyy,-1,getdate()) ǰ1��,dateadd(qq,-1,getdate()) ǰ1������,dateadd(mm,-1,getdate()) ǰ1��,dateadd(dd,-11,getdate()) ǰ11��;

--datediff���ڱȽ�
select datediff(yyyy,'2017-11-1',getdate()) �����,datediff(mm,'2017-11-1',getdate()) ����·�,datediff(dd,'2017-11-1',getdate()) �������;
--datepart��������ȡ���ڵ�һ����
select datepart(yyyy,getdate()) ��,datepart(mm,getdate())��,datepart(dd,getdate()) ��,datepart(qq,getdate()) ����,datepart(wk,getdate()) һ���еĵڼ�������;

--0����1900-1-1 00:00:00
--ͨ�����ں������㣬��ʾ2018��ĵ�һ���ʱ��
select dateadd(yyyy,datediff(yyyy,0,getdate())+1,0) '2018��ĵ�һ��';
select dateadd(yyyy,118,0)
select year(getdate()),month(getdate()),day(getdate());

select * from �ɼ��� order by �ɼ� desc;


select ����,�γ���,�ɼ�,rank() over (order by �ɼ� desc) �ɼ����� from �ɼ��� c 
inner join student s on c.ѧ��=s.ѧ��
inner join �γ̱� k on c.�γ̺�=k.�γ̺�


select ����,�γ���,�ɼ�,dense_rank() over (order by �ɼ� desc) �ɼ����� from �ɼ��� c 
inner join student s on c.ѧ��=s.ѧ��
inner join �γ̱� k on c.�γ̺�=k.�γ̺�

--��ѧ����

select cos(pi()) ,sin(pi()/2),abs(-100),rand() �����,pi() Բ����,ceiling(8.01) ���ش��ڵ��ڵ�ǰ������С����;
select ceiling(-9.9) ���ش��ڵ��ڵ�ǰ������С����,round(8.888888,2) �������뱣��2λС��;
--e=2.718.....
select sqrt(9) ��ƽ��,square(9) ƽ��,log(10) ��eΪ����,log10(100) ��10Ϊ����,power(9,3) '9��3�η�';

--�ַ�������
select ascii(9) �ַ�תascii,char(56) asciiת�ַ�,len('admin') �ַ�������,substring('abcdefg',2,3) ���ִ�;
select substring('abcdefg',2,3) ���ִ�,left('abcdefg',3) ǰ3���ַ�,right('abcdefg',3) ��3���ַ�
select ltrim('             abcdefghijkl       '),rtrim('             abcdefghijkl       '),ltrim(rtrim('             abcdefghijkl       '));
select charindex('d','abcdefg') �ַ����ַ����е�����,lower('ABCDefG') ��дתСд,upper('abcdEFg') Сдת��д;
--convert����ת������
select (convert(varchar(4),year(getdate()))+'-'+convert(varchar(2),month(getdate()))+'-'+convert(varchar(2),day(getdate()))) ��ǰ����;
--cast����ת������
select (cast(year(getdate()) as varchar(4))+'-'+cast(month(getdate()) as varchar(2))+'-'+cast(day(getdate()) as varchar(20))) ��ǰ����;


--ϵͳ������
select * from sysindexes where indid=1;
--��������
--����Ҳ���������Ǽ���������һ����ֻ����һ����������
select * from student;
--������ͨ����
create index idx_classid on student(�༶���);
--����Ψһ����
create unique index idx_cardno2 on student(���֤��);
--ɾ������
drop index idx_classid on student;
drop index idx_cardno2 on student;

sp_help student;
--�鿴������
sp_helpindex student;
--��ѯʱ����ָ������
select * from student with(index=un_cardno);























select * from classes;
select * from �γ̱�;
select * from student;
--ʹ��ϵͳ�洢���̴��ڱ�ṹ������Լ��
sp_help student;

select * from �ɼ���;
delete �ɼ��� where ѧ��>4;


--������ϼ�
alter table �ɼ��� add constraint pk_score primary key(ѧ��,�γ̺�);
--��ѧ���������
alter table �ɼ��� add constraint FK_SCORE_STUDENT foreign key(ѧ��) references student(ѧ��);
alter table �ɼ��� add constraint FK_SCORE_COURSE foreign key(�γ̺�) references �γ̱�(�γ̺�);




select * from classes;
select * from �γ̱�;
select * from student;
select * from �ɼ��� order by �γ̺�;


--5.1.	��ѯ����ѧ����������ѧ�ż��༶����
--5.2.	��ѯ����ѧ�����ſγ̵ĳɼ����г��������༶�����γ������ɼ�
select ����,�༶����,�γ���,�ɼ� from �ɼ��� c 
inner join �γ̱� k on c.�γ̺�=k.�γ̺�
inner join student x on x.ѧ��=c.ѧ��
inner join classes b on b.�༶���=x.�༶���

select ����,�༶����,�γ���,�ɼ� from �ɼ��� c, �γ̱� k,student x,classes b
where c.�γ̺�=k.�γ̺� and x.ѧ��=c.ѧ�� and b.�༶���=x.�༶���;

select ����,�༶����,�γ���,�ɼ� from �ɼ��� c 
left join �γ̱� k on c.�γ̺�=k.�γ̺�
left join student x on x.ѧ��=c.ѧ��
left join classes b on b.�༶���=x.�༶���

--5.3.	�ֱ�ʹ���Ӳ�ѯ�����Ӳ�ѯʵ�֣���ѯST0801���C����ƽ���ɼ�
--round�������룬��ȷ��С��λ���2λ
select round(avg(�ɼ�),2) from �ɼ��� 
where ѧ�� in(select ѧ�� from student where �༶���=(select �༶��� from classes where �༶����='��ͼ201702��'))
and �γ̺�=(select �γ̺� from �γ̱� where �γ���='C����')

select round(avg(�ɼ�),2) from �ɼ��� c
inner join �γ̱� k on c.�γ̺�=k.�γ̺�
inner join student x on x.ѧ��=c.ѧ��
inner join classes b on b.�༶���=x.�༶���
where �༶����='��ͼ201702��' and �γ���='C����'

--5.4.	��ѯ����C���Գɼ��������ڰ༶ƽ���ɼ��ߵ�ѧ��

select x.*,c.�ɼ� from �ɼ��� c
inner join �γ̱� k on c.�γ̺�=k.�γ̺�
inner join student x on x.ѧ��=c.ѧ��
inner join classes b on b.�༶���=x.�༶���
where �༶����='��ͼ201702��' and �γ���='C����' and c.�ɼ�>(
select round(avg(�ɼ�),2) from �ɼ��� 
where ѧ�� in(select ѧ�� from student where �༶���=(select �༶��� from classes where �༶����='��ͼ201702��'))
and �γ̺�=(select �γ̺� from �γ̱� where �γ���='C����')
)

--5.5.	����C����û�гɼ�������ѧ������Ϣ��ʹ��existsʵ�֣�

select * from student s 
where not exists(select * from �ɼ��� where �γ̺�=(select �γ̺� from �γ̱� where �γ���='���ݿ�' and s.ѧ��=ѧ��))


--5.6.	ʹ��SQL��ST0801�������ѧ������Ϣ���뵽һ���±�StudentST0801��
drop table StudentST0801;
select * into StudentST0801 from student where �༶���=(select �༶��� from classes where �༶����='��ͼ201702��')
select * from StudentST0801;
delete StudentST0801 where ѧ��>2;


--5.7.	��ѯ��Student���д��ڣ�����StudentST0801���в����ڵ�ѧ��
select * from student where ѧ�� not in(select ѧ�� from StudentST0801);

--5.8.	ɾ��Student200801�������ѧ��
delete StudentST0801 where ѧ�� in(select ѧ�� from classes where �༶����='��ͼ201702��')

delete
truncate
drop 



--5.9.	��ѯClasses���StudentST0801�������ѧ���ϵ�һ���������
select * from student s inner join classes c on s.�༶���=c.�༶���;

--6.1.	��һ��SQL��� ��ѯ��ÿ�ſζ�����80�ֵ�ѧ������ �ֱ�ʹ�����Ӳ�ѯ���Ӳ�ѯʵ��

	select ���� from student where ѧ�� in(select ѧ�� from �ɼ��� group by ѧ�� having min(�ɼ�)>80);

	select * from �ɼ���;

--6.2.	��ѯ������ͬ����ѧ�����г��������༶
select * from student;
insert into student values(5,'����','361001199008081123','��',88,341000,getdate(),1);
insert into student values(6,'����','361001199008081124','��',28,341000,getdate(),1);

select ����,�༶���� from student s inner join classes c on c.�༶���=s.�༶���
where ���� in (select ���� from student group by ���� having count(����)>1);

--6.3.	����ÿ��ѧ��ÿ�ſγ̶�Ӧ���гɼ�����ѯ��û�гɼ���ѧ������γ̣��г��������༶�����γ�

select ѧ��,����,�γ��� from student s cross join �γ̱� k 
where not exists(select * from �ɼ��� where ѧ��=s.ѧ�� and �γ̺�=k.�γ̺�);


--6.4.	��ѯ�ó����½����
select * from �γ̱�
--isnull������ֵ��Ĭ��ֵ������

select ����,
isnull((select �ɼ� from �ɼ��� where ѧ��=s.ѧ�� and �γ̺�=1),0) HTML,
isnull((select �ɼ� from �ɼ��� where ѧ��=s.ѧ�� and �γ̺�=2),0) C����,
isnull((select �ɼ� from �ɼ��� where ѧ��=s.ѧ�� and �γ̺�=3),0) ���ݿ�
 from student s ;



--��ͼ�﷨
/*
	create view ��ͼ����

	as

		��ѯ���
		ע�����
			1.��ͼ�в���ʹ��order by���;
			2�����ͼ����with check option ����ô�ڶ���ͼ���������޸ģ�ɾ��ʱ�����������ͼ�����������ܲ����ɹ�

*/

select * from student;

--������ͼ
create view vstudent as select * from student;
--������ͼ
select * from vstudent;
--�޸���ͼ
alter view vstudent as select distinct �Ա� from student;
--ɾ����ͼ
drop view vstudent;
create view vstudent as select distinct �Ա� from student;
create view vstudent as select �Ա�,count(*) ���� from student group by �Ա�;
--��ͼ����ɸѡ����
create view vstudent as select ѧ��,����,���֤��,�Ա� from student where �༶���=2;


select * from vstudent where �Ա�='��';
--����ͼ��������¼
insert into vstudent values(7,'СС','361001199008081132','Ů');
--�޸���ͼ����
update vstudent set �Ա�='Ů' where  ѧ��=3;
--ɾ����ͼ�е�����
delete vstudent where ѧ��=7;

select * from student
update student set �༶���=2 where ѧ��=7;

create view vstudent2 as select * from student where �༶���=2 and ����<30 with check option;

select * from vstudent2;
--�޸�����
update vstudent2 set ����=29 where ѧ��=3;

insert into vstudent2 values(7,'СС','361001199008081132','Ů',21,'341000',getdate(),2);
drop view vstudent2
--������ͼ
create view vstudent2 WITH ENCRYPTION as select * from student where �༶���=2 and ����<30 ;


--�洢���̴�����¼
exec sp_addlogin 'abc123','abc';
--ɾ����¼
sp_droplogin 'abc123';

--ͨ���������¼
create login abc456 with password='123456';
--�����û�
create user abc456 for login abc456;










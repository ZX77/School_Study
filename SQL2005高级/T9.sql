/*
	����������һ������Ĵ洢���̣������ڱ��
		1.һ����ֻ��3�д�������ɾ�����޸ģ�����
		2.��������ʱ��ϵͳ���ϴ�����������
		3.�����ڴ�������������ʱ�����ǲ�������ϵͳ��
		4.һ���������п���ͬʱ��������¼�;
	2���߼�����2���߼���ֻ���ڴ�������ʹ�ã��������������ʹ��(������)
		1.inserted������������������޸�����в���������У�
		2.deleted���������ɾ�������޸ģ��ӱ���ɾ����������		


*/

select * from student;
--������������ѧ������С��10��ʱ����������ѧ������

create trigger tr_checkAge on student for insert

as 
	--inserted�߼�����student��ṹ��һ�µģ�����ֻ�������ļ�¼����
	if (select ���� from inserted)<10
	begin
		print '����̫С�����ʺ�ѧϰ�������רҵ';
		--�ع�����
		rollback transaction;
	end;
go

 insert into student values(8,'߹߹','362101198808081166','��',9,'341000',getdate(),2);
 insert into student values(9,'߹߹','362101198808081166','��',19,'341000',getdate(),2);

select * from classes;
alter table classes add �༶���� int;

update classes set �༶����=0;

alter trigger tr_modifycnt on student for insert

as 
	declare @classid int;
	select @classid=�༶��� from inserted ;
	--���°༶���иð������
	--update classes set �༶����=(select count(*) from student where �༶���=@classid) where �༶���=@classid;
	update classes set �༶����=�༶����+1 where �༶���=@classid;
go

 insert into student values(10,'Ҷ��','362101198808081168','��',19,'341000',getdate(),1);
 insert into student values(11,'Ҷ��2','362101198808081169','��',19,'341000',getdate(),2);
 insert into student values(12,'Ҷ��4','362101198808081170','��',19,'341000',getdate(),3);
select * from classes;
select * from student order by �༶���;
--ɾ��ѧ����Ϣʱ��ͬʱ���°༶�������
alter trigger tr_deletecnt on student for delete
as 
	declare @classid int;
	select @classid=�༶��� from deleted ;
	--���°༶���иð������
	update classes set �༶����=�༶����-1 where �༶���=@classid;
	
go
delete student where ѧ��=4;
select * from �ɼ���;
--�޸�ѧ����Ϣʱ��ͬʱ���°༶�������
alter trigger tr_updatecnt on student for update
as 
	declare @classid int;
	--����༶����ֶε�ֵ�����˱仯�͸��£�����ִ��
	if update(�༶���)
	begin 
		select @classid=�༶��� from deleted ;
		--���°༶���иð������
		update classes set �༶����=�༶����-1 where �༶���=@classid;
		select @classid=�༶��� from inserted ;
		--���°༶���иð������
		update classes set �༶����=�༶����+1 where �༶���=@classid;
	end
go

update student set ����=20 where ѧ��=10;
--�鿴������
select * from sys.triggers;
select * from sys.trigger_events;
--���ô�����
disable trigger tr_modifycnt  on student;
--���ô�����
enable trigger tr_modifycnt  on student;


insert into student values(14,'Ҷ��6','362101198808081172','��',19,'341000',getdate(),3);
select * from classes;
select * from student order by �༶���;
SELECT * FROM STUDENT;

/*
�����α�

	declare �α������ cursor for ��ѯ��� for read only | update of �ֶ��б�

	1.�α�ʹ��������رգ������´ξ�ʹ�ò��ˣ�
*/

--1.����ֻ���α�
declare cur cursor forward_only for select * from student;
--2.���α�
open cur;
--3.��ȡ��ǰ�е�ֵ
fetch next from cur;
--ֻ���α�ֻ��ʹ��next
--fetch first from cur;
--4.�ر��α�
close cur;
--5.�ͷ��α�
deallocate cur;


--1.��������α�
declare cur cursor scroll for select * from student;
--2.���α�
open cur;
--3.��ȡ��ǰ�е�ֵ
fetch next from cur;
--��һ��
fetch first from cur;
--���һ��
fetch last from cur;
--��һ��
fetch prior from cur;
--���Զ�λ
fetch absolute 3 from cur;
--��Զ�λ
fetch relative 2 from cur;
fetch relative -3 from cur;
--4.�ر��α�
close cur;
--5.�ͷ��α�
deallocate cur;


-----------------------------------

/*�α�״̬
	@@FETCH_STATUS=0��ȡ���ݳɹ�,
	@@FETCH_STATUS=-1��ȡ����ʧ��,
	@@FETCH_STATUS=-2��ȡ����ʧ��,
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
	��ѯ�б����м����ֶΣ��ͱ��붨�弸����Ӧ�ı���
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
	--��ȡ���֤����
	set @temp = cast(substring(@cardno,7,4) as int);
	set @age = year(getdate())-@temp;
	--update student set ����=@age where ѧ��=@studid;
	update student set ����=@age where current of cur; --current of cur����ǰ��
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
declare cur cursor for select * from student for update of ����;--���ƿ��Ը��µ���
open cur;
select @@cursor_rows
fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
while @@FETCH_STATUS=0
begin
	--��ȡ���֤����
	set @temp = cast(substring(@cardno,7,4) as int);
	set @age = year(getdate())-@temp;
	update student set ����=@age where current of cur; --current of cur����ǰ��
	fetch next from cur into @studid,@studname,@cardno,@sex,@age,@postcode,@indate,@classid;
end;
close cur;
deallocate cur;


select * from student;

------------------------------------------------------
--���徲̬�α�
--ֻ�ж��徲̬�α�ʱ��@@cursor_rows�������ص�ֵ�������壬dynamic�α귵��-1��Ĭ���α���Ƕ�̬��ֻ���α�
declare cur cursor static for select * from student;--���ƿ��Ը��µ���
open cur;
select @@cursor_rows
fetch next from cur;
while @@FETCH_STATUS=0
begin
	fetch next from cur;
end;
close cur;
deallocate cur;

create table book(
       bid number(7) primary key,
       bname varchar(200),
       bpubtime date
       );

select * from book;

insert into book values(101,'�����뺣',to_date('2007-10-01','yyyy-MM-dd'));
insert into book values(102,'��Ů��Ұ��',to_date('2008-10-02','yyyy-MM-dd'));
insert into book values(103,'�����',to_date('2008-10-03','yyyy-MM-dd'));
insert into book values(104,'ս�����ƽ',to_date('2009-10-04','yyyy-MM-dd'));
insert into book values(105,'ƽ��������',to_date('2010-10-05','yyyy-MM-dd'));
insert into book values(106,'����¶�',to_date('2011-10-06','yyyy-MM-dd'));
create table reader(
       rid number(3) primary key,
       rname varchar2(100),
       rbn number(3)
       );
insert into reader values(110,'����',104);
insert into reader values(111,'����',103);
insert into reader values(112,'����',101);
insert into reader values(113,'����',106);
insert into reader values(114,'����',102);
insert into reader values(115,'����',null);
select *from reader;
//��ʼΪ���߱�reader�е��ֶ�rbn��ӷǿ�Լ��

alter table reader  add constraint check_rbn check(rbn is not null) enable novalidate;
enable novalidate;

insert into reader values(116,'����',105);
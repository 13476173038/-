create table book(
       bid number(7) primary key,
       bname varchar(200),
       bpubtime date
       );

select * from book;

insert into book values(101,'老人与海',to_date('2007-10-01','yyyy-MM-dd'));
insert into book values(102,'美女与野兽',to_date('2008-10-02','yyyy-MM-dd'));
insert into book values(103,'红与黑',to_date('2008-10-03','yyyy-MM-dd'));
insert into book values(104,'战争与和平',to_date('2009-10-04','yyyy-MM-dd'));
insert into book values(105,'平凡的世界',to_date('2010-10-05','yyyy-MM-dd'));
insert into book values(106,'百年孤独',to_date('2011-10-06','yyyy-MM-dd'));
create table reader(
       rid number(3) primary key,
       rname varchar2(100),
       rbn number(3)
       );
insert into reader values(110,'李云',104);
insert into reader values(111,'马彦',103);
insert into reader values(112,'王哲',101);
insert into reader values(113,'张译',106);
insert into reader values(114,'刘年',102);
insert into reader values(115,'刘年',null);
select *from reader;
//开始为读者表reader中的字段rbn添加非空约束

alter table reader  add constraint check_rbn check(rbn is not null) enable novalidate;
enable novalidate;

insert into reader values(116,'王芳',105);
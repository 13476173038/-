select  * from book;
select  * from reader;
ALTER TABLE reader ADD FOREIGN KEY (rbn) REFERENCES book(bid);
delete from book where bid=105;
delete from reader where rbn=105;

--��ҵ1�������������ӱ������ݵĻ������������ɾ�����ˣ���ô�ô�����ʵ�ּ���ɾ��
create or replace trigger tri_book_cascade
before delete on  book
for each row 
begin 
    delete from reader where rbn=:old.bid;
end tri_book_cascade;

delete from book where bid=105;

--��ҵ2�����Ĺ淶�����壩�����������α� 
/*book����һ���α� ȫ��
reader����һ���α� return(ref)
��ʵ�ֶ��߽���(�洢���̣� �������ݱ��в������ݣ�Ȼ����ʾ������
*/
drop package pk_test
create or replace package pk_test
is 
       cursor c_book return book%rowtype;
       cursor c_reader return reader%rowtype;
       procedure ups_book_reader_add(v_bid book.bid%type,
                                     v_bname book.bname%type,                                     
                                     v_rid reader.rid%type,
                                     v_rname reader.rname%type
                                    );
end pk_test;

create or replace package body pk_test
is 
       cursor c_book return book%rowtype is select * from book;
       cursor c_reader return reader%rowtype is select * from reader;
       procedure ups_book_reader_add(v_bid book.bid%type,
                                     v_bname book.bname%type,
                                     v_rid reader.rid%type,
                                     v_rname reader.rname%type
                                    )
       is 
       begin
                 dbms_output.put_line('ͼ�����ݱ�:');
                 for v_temp1 in c_book loop
                    dbms_output.put_line(v_temp1.bid||' '||v_temp1.bname||' '||v_temp1.bpubTime); 
                 end loop;
                 dbms_output.put_line('�������ݱ�:');
                 for v_temp2 in c_reader loop
                    dbms_output.put_line(v_temp2.rid||' '||v_temp2.rname||' '||v_temp2.rbn); 
                 end loop;
                 
                 insert into book values(v_bid,v_bname,to_date('2010-10-10','yyyy-MM-dd'));
                 dbms_output.put_line('ִ�����ݱ�book���:'||sql%rowcount);
                 commit;
                 insert into reader values(v_rid,v_rname,v_bid);
                 dbms_output.put_line('ִ�����ݱ�reader���:'||sql%rowcount);
                 commit;
       end ups_book_reader_add;
end pk_test;




begin
    pk_test.ups_book_reader_add();
end;

declare
    v_bid book.bid%type;
    v_bname book.bname%type;
    v_bpubtime book.bpubtime%type;
    v_rid reader.rid%type;
    v_rname reader.rname%type;
begin
    v_bid:='&������ͼ����:';
    v_bname:='&������ͼ������:';
    v_rid:='&��������߱��:';
    v_rname:='&�������������:';
    pk_test.ups_book_reader_add(v_bid,v_bname,v_rid,v_rname);
end;



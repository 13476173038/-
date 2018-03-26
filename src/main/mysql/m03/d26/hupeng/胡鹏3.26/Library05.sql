#3
USE  Library;
BEGIN;
UPDATE  book  SET bcount=bcount-1  WHERE  bid=0006;
INSERT INTO  borrow(rid,nif,lenddate) VALUES(0009,0006,NOW());
UPDATE  reader SET  lennum=lennum+1  WHERE  rid=0009;
COMMIT;

#4
USE library;
BEGIN;
INSERT INTO  penalty(rid,bid,pdate,ptype,amount) VALUES(0008,0007,NOW(),1,4.6);
UPDATE borrow  SET returndate=NOW()  WHERE rid=0008;
UPDATE reader  SET  lennum=lennum-1  WHERE  rid=0008;
UPDATE  book  SET  bcount=bcount+1  WHERE  bid=0007;
COMMIT;

#5
USE Library;

CREATE  INDEX index_book_bname ON book(bname);

DROP  VIEW  IF  EXISTS  view_book;

CREATE  VIEW  view_book
AS
SELECT  bname  AS 图书名称,
        willdate  AS  到期日期,
        rname   AS  读者姓名
FROM   borrow
INNER  JOIN   book  ON   borrow.`nif`=bid
INNER  JOIN   reader ON  borrow.`rid`=reader.`rid`;  


CREATE  VIEW  view_book_reader
AS
SELECT  bname  AS  图书名称,
        bcount  AS  馆存量,
       bcount-COUNT(nif)  AS  可借阅数量
FROM    book
INNER JOIN  borrow  ON    book.`bid`=borrow.`nif`           
GROUP BY  borrow.`nif`;

#6
mysql  _u root _p  libraryDB<D:\BACKUP\Library_20180325.sql

SELECT * FROM  reader  INTO OUTFILE  D:/BACKUP/reader_Java.txt;

SELECT * FROM  book  INTO OUTFILE  D:/BACKUP/book_Java.txt;
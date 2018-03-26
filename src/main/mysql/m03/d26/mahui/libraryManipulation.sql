page 128 #3
ALTER TABLE book ADD presentcount INT NOT NULL;
UPDATE  book SET presentcount=89
WHERE bid='1007004';
INSERT INTO book VALUES('1007009','红楼梦','曹雪芹','人民文学出版社','2010-03-25','100',48,48);
BEGIN
START TRANSACTION
INSERT INTO borrow VALUES('017','1007009','2018-03-25','2018-04-25',NULL);
UPDATE book SET presentcount=47 WHERE bid=1007009;
UPDATE reader SET lendnum=2 WHERE rid='017';
COMMIT;

page128 #4
INSERT INTO book VALUES('1007010','西游记','吴承恩','人民文学出版社','2010-01-20','100',40,20);
INSERT INTO reader VALUES('018','刘冰冰',1,'九龙');
INSERT INTO borrow VALUES('018','1007010','2018-01-25','2018-02-25',NOW());
BEGIN
START TRANSACTION
INSERT INTO penalty VALUES('018','1007010','2018-03-25',1,4.6);
UPDATE book SET presentcount=47 WHERE bid=1007009;
UPDATE reader SET lendnum=0 WHERE rid=018;
UPDATE book SET presentcount=21 WHERE price=40;
COMMIT;

page128 #5
CREATE VIEW v_libraryAdministrator
 AS
	SELECT
	(SELECT bname FROM book b WHERE b.bid=w.nif)AS 图书名称 ,
	(SELECT rname FROM reader r WHERE r.rid=w.rid) AS 读者姓名,
	willdate AS 图书到期日期
	FROM borrow w
	WHERE  DATEDIFF(willdate ,NOW())<0;
	
CREATE VIEW v_reader
AS 
  SELECT 
  bname AS 图书名称,
  bcount AS 馆存数量,
  bcount-COUNT(w.nif) AS 可借出数量
  FROM book b
  LEFT JOIN borrow w
  ON w.nif=b.bid
  GROUP BY w.nif;
  
SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT * FROM penalty;

 CREATE INDEX bookstatus ON book(bname);   
 
 SHOW INDEX FROM bookstatus;
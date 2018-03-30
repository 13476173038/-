#第1题
CREATE TABLE sales
(
	NO INT,
	NO2 INT,
	num   DOUBLE,
	saDate DATETIME
)

INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21')
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21')
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01')
INSERT INTO sales VALUES(1234,567890,66.5,'2004-09-21')
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01')
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27')
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21')

#select方法
SELECT NO AS NO,
       NO2,
     (SELECT SUM(num) WHERE MONTH(saDate)=09)  AS  九月,
     (SELECT SUM(num) WHERE MONTH(saDate)=10) AS   十月,
     (SELECT num WHERE MONTH(saDate)=11)  AS  十一月,
     (SELECT num WHERE MONTH(saDate)=12)   AS  十二月
FROM sales   
GROUP BY NO,NO2
ORDER BY  NO,NO2
#case方法
SELECT NO,NO2,
       SUM(CASE WHEN EXTRACT(MONTH FROM sadate)='9' THEN num ELSE 0 END) 九月,
       SUM(CASE WHEN EXTRACT(MONTH FROM sadate)='10' THEN num ELSE 0 END) 十月,
       SUM(CASE WHEN EXTRACT(MONTH FROM sadate)='11' THEN num ELSE 0 END) 十一月,
       SUM(CASE WHEN EXTRACT(MONTH FROM sadate)='12' THEN num ELSE 0 END) 十二月   
FROM sales 
GROUP BY NO,NO2;  


#第2题
CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班')
INSERT INTO ABC VALUES('李大',20,'正','一班')
INSERT INTO ABC VALUES('张五',15,'负','一班')
INSERT INTO ABC VALUES('赵三',40,'负','二班')
INSERT INTO ABC VALUES('王小',5 ,'负','二班')


#方法一
SELECT A,(SELECT -B  WHERE  C='负' ) AS B,D FROM abc  TMP  GROUP BY TMP.A
UNION
SELECT A,(SELECT B  WHERE  C='正' ) AS B,D FROM abc  temp
GROUP BY temp.D
#方法二
SELECT a,SUM(b),d FROM
(SELECT a,b,d FROM abc WHERE c='正'
UNION
SELECT a,-b,d FROM abc WHERE c='负') temp
GROUP BY a
ORDER BY SUM(b) ,d DESC

#方法三
SELECT A, 
SUM(B*(CASE C WHEN '正' THEN 1 ELSE -1 END)) AS B,
D 
FROM abc 
GROUP BY A,D

#第三题
USE library;

DELIMITER ;;
CREATE  PROCEDURE  create_penalty_01(IN rid INT,IN bid INT,IN pdate DATETIME,IN ptype INT,IN amount DOUBLE,IN rname VARCHAR(8),IN bname VARCHAR(8))
BEGIN 
       DECLARE  
       INSERT INTO  penalty(rid,bid,pdate,ptype,amount) VALUES((SELECT rid FROM reader WHERE rname='刘冰冰'),
       (SELECT @bid FROM book WHERE bname='西游记'),NOW(),1,4.6);
       UPDATE borrow  SET returndate=NOW()  WHERE rid=(SELECT @rid FROM reader WHERE rname='刘冰冰');
       UPDATE reader  SET  lennum=lennum-1  WHERE  rname=@'刘冰冰';
       UPDATE  book  SET  bcount=bcount+1  WHERE  bname=@'西游记';

END
;;
DELIMITER ;

CALL	create_penalty_01(7);

 






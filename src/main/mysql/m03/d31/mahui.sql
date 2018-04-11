#sale
SELECT empid,proid,
SUM(CASE WHEN MONTH(saDate)=9 THEN ROUND(num,2) ELSE num=0 END)AS 九月,
SUM(CASE WHEN MONTH(saDate)=10 THEN ROUND(num,2) ELSE num=0 END)AS 十月,
SUM(CASE WHEN MONTH(saDate)=11 THEN ROUND(num,2) ELSE num=0 END)AS 十一月,
SUM(CASE WHEN MONTH(saDate)=12 THEN ROUND(num,2) ELSE num=0 END)AS 十二月
FROM sales
GROUP BY proid

#abc
SELECT A,
SUM(CASE WHEN C='正' THEN B ELSE -B END)AS B,D
FROM ABC
GROUP BY A;

//还书
DELIMITER ;;
	CREATE PROCEDURE returnbook(IN rr CHAR,OUT returndate01 DATE)
BEGIN
	UPDATE borrow SET returndate=NOW() WHERE rid=rr;
	SELECT returndate INTO returndate01 FROM borrow WHERE rid=rr;
	
END
;;
DELIMITER ;
	CALL returnbook('018',@s);
	SELECT @s AS 还书日期；

SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT * FROM penalty;
//馆存量加1
DELIMITER ;;
	CREATE PROCEDURE raisenum(IN nif CHAR, OUT nowcount INT)
BEGIN
	DECLARE bid VARCHAR;
	UPDATE book presentcount=presentcount+1 WHERE bid=nif;
	SELECT presentcount INTO nowcount FROM book WHERE bid=nif;
END
;;
DELIMITER ;
	CALL raisenum( '1007010',@ii);
	SELECT @ii AS 目前馆存量；
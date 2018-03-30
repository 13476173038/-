CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)

INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');


SELECT a,SUM(b),d FROM
(SELECT a,b,d FROM abc WHERE c='正'
UNION
SELECT a,-b,d FROM abc WHERE c='负') temp
GROUP BY a
ORDER BY SUM(b) ,d DESC
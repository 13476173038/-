SELECT empid,proid ,
saDate LIKE '%-09-%'  AS 9月,
saDate LIKE '%-10-%' AS 10月,
saDate LIKE '%-11-%' AS 11月,
saDate LIKE '%-12-%' AS 12月 
FROM sales ;


SELECT 
(SELECT  DISTINCT empid,proid FROM sales ),
(SELECT SUM(num) WHERE MONTH(saDate)=09)  AS  九月,
(SELECT SUM(num) WHERE MONTH(saDate)=10) AS   十月,
(SELECT num WHERE MONTH(saDate)=11)  AS  十一月,
(SELECT num WHERE MONTH(saDate)=12)   AS  十二月
FROM sales;


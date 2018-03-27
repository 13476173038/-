page71 3#

SELECT b.bid,b.bname,b.author,b.pubcomp,b.price
FROM book b
WHERE b.bid
NOT IN(
SELECT bw.nif
FROM borrow bw
);

page71 4#
SELECT
(SELECT rname FROM reader  WHERE rid=p.rid) AS 读者名称,
(SELECT bname FROM book WHERE bid=p.bid)AS 图书名称,
pdate AS 罚款日期,
amount AS 罚款金额
FROM penalty p;

page71 5#
SELECT rid AS 读者编号,
(SELECT rname FROM reader WHERE b.rid=rid;) AS 读者姓名,
(SELECT bname FROM  book WHERE b.nif=bid;) AS 图书名称,
b.lenddate AS 借书日期,
b.willdate AS 应归还日期
FROM borrow b
WHERE rid IN (
SELECT rid FROM reader WHERE raddress IS NULL)
ORDER BY b.rid DESC,b.lenddate DESC;

page 98 #2
SELECT rid AS 读者编号, rname AS 读者姓名,raddress AS 读者地址
 FROM reader a 
 WHERE NOT EXISTS (SELECT * FROM borrow WHERE borrow.`rid`=rid );

page98 #3
SELECT
(SELECT rname FROM reader  WHERE rid=w.rid)AS 读者,
(SELECT bname FROM book  WHERE bid=w.nif)AS 书名,
willdate AS 应归还日期
FROM borrow w
WHERE returndate IS NULL AND DATEDIFF(willdate,NOW()) <0; 

page98 #4
SELECT bname AS 书名,
b.bcount -COUNT(w.nif)AS 此书剩余数
FROM book b
LEFT JOIN borrow w
ON  bid=w.nif
GROUP BY w.nif;

page98 #5
SELECT 
(SELECT rname FROM reader WHERE rid=w.rid)AS 读者姓名,
COUNT(rid)AS 借阅次数
FROM borrow w
WHERE returndate IS NOT NULL
GROUP BY w.rid;

page98 #6
SELECT 
(SELECT rname FROM reader WHERE rid=p.rid)AS 读者姓名,
CONVERT(SUM(amount),DECIMAL(10,2)) AS 罚款总金额
FROM penalty p
GROUP BY p.rid
HAVING 罚款总金额>5;

page98 #7
SELECT 
(SELECT bname FROM book WHERE bid=w.nif)AS 书名,
COUNT(nif)AS 书的借阅次数
FROM borrow w
WHERE returndate IS NOT NULL
GROUP BY nif
ORDER BY COUNT(nif) DESC
LIMIT 0,5;
 




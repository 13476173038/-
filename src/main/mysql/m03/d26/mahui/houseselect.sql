
查找一个街区至少有2条街道附近有房出租情况,包括户型,姓名,街区和街道
SELECT 
(SELECT htname FROM hos_type WHERE htid=h.htid)AS 户型,
(SELECT uname  FROM sys_user WHERE uid=h.uid)AS 姓名,
(SELECT dname  FROM hos_district d
 WHERE did =(SELECT sdid FROM hos_street s WHERE sid =h.sid )
)AS 区县,
h.topic AS 街道
FROM hos_house h
WHERE h.SID IN(
  SELECT sid FROM hos_street WHERE sdid IN(
    SELECT temp.sdid FROM(SELECT a.SID AS sid,b.SDID AS sdid,COUNT(*) FROM  hos_house a
		       INNER JOIN hos_street b ON a.SID=b.SID
		       GROUP BY a.SID,b.SDID)  temp
    GROUP BY temp.sdid
    HAVING COUNT(*)>1
  )
)

按季度统计各区县,各街道,各种户型房屋的出租情况
SELECT QUARTER(h.HTIME) AS 季度,
d.DName AS 区县,
s.SName AS 街道,
t.HTName AS 户型,
COUNT(*) AS 房屋数量 FROM hos_house h
INNER JOIN hos_street s ON h.SID=s.SID
INNER JOIN hos_district d ON s.SDID=d.DID
INNER JOIN hos_type t ON h.HTID=t.HTId
GROUP BY QUARTER(h.HTIME),d.DName,s.SName,t.HTName
UNION
SELECT QUARTER(h.HTIME) AS 季度,
d.DName AS 区县,
' 小计','',COUNT(*) AS 房屋数量 FROM hos_house h
INNER JOIN hos_street s ON h.SID=s.SID
INNER JOIN hos_district d ON s.SDID=d.DID
INNER JOIN hos_type t ON h.HTID=t.HTID
GROUP BY QUARTER(h.HTIME),d.DName
UNION
SELECT QUARTER(h.HTIME) AS 季度,
' 合计','','',COUNT(*) AS 房屋数量 FROM hos_house h
INNER JOIN hos_street s ON h.SID=s.SID
INNER JOIN hos_district d ON s.SDID=d.DID
INNER JOIN hos_type t ON t.HTID=h.HTID
GROUP BY QUARTER(h.HTIME)
ORDER BY 1,2,3,4; 

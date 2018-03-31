
//还书
DELIMITER ;;
CREATE PROCEDURE ups-01(IN woman VARCHAR,IN bookname VARCHAR)
BEGIN 
	INSERT penalty VALUES((SELECT rid FROM reader WHERE rname='woman'),
	(SELECT bid FROM book WHERE bname='bookname'),NOW(),1,4.6 );
	UPDATE borrow SET returndate=NOW() WHERE rid=(SELECT rid FROM reader WHERE rname='woman');
	UPDATE reader  SET lendnum=lendnum-1 WHERE rname='woman';
	UPDATE book SET presentcount=presentcount+1 WHERE bname='bookname';
	
END
;;
DELIMITER ;

CALL ups-01('刘冰冰'，'西游记');
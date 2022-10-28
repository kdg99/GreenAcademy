SELECT * FROM `customer`

SELECT a.*, b.`name`, c.`prodName` FROM `order` AS a 
		JOIN `customer` AS b ON a.orderId=b.custId
		JOIN `product` AS c ON a.orderProduct=c.prodNo;
		
INSERT INTO `order` SET `orderId`='a101'
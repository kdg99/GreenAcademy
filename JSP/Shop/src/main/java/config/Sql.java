package config;

public class Sql {
	
	//List.jsp
	public static final String SELECT_CUSTOMERS	= "SELECT * FROM `customer`";
	public static final String SELECT_PRODUCTS 	= "SELECT * FROM `product`";
	public static final String SELECT_ORDERS 	= "SELECT a.*, b.`name`, c.`prodName` "
												+ "FROM `order` AS a "
												+ "JOIN `customer` AS b ON a.orderId=b.custId "
												+ "JOIN `product` AS c ON a.orderProduct=c.prodNo";
	
	//OrderTable
	public static final String INSERT_ORDER = "INSERT INTO `order` SET "
											+ "`orderNo`=?,"
											+ "`orderId`=?,"
											+ "`orderProduct`=?,"
											+ "`orderCount`=?,"
											+ "`orderDate`=NOW()";
	
	public static final String SELECT_COUNT_ORDERNO = "SELECT COUNT(`orderNo`) FROM `order`";
}

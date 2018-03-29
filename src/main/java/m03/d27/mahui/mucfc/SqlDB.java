package com.mucfc;
  import java.sql.*;  
public class SqlDB {
	// 定义数据库驱动程序  
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";  
    // 数据库连接地址  
    private static final String DBURL = "jdbc:mysql://localhost:3306/library";  
    // 数据库用户名  
    private static final String DBUSER = "root";  
    private static final String DBPASS = "root";  
  
    /** 
     * 创建数据库连接一初始操作 
     *  
     * @return 数据库连接
     */  
    public static Connection getconnection() {  
        Connection conn = null;  
        try {  
            // 1.注册驱动  
            Class.forName(DBDRIVER);  
            // 2.获取连接  
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);  
            // 3.创建Statement对象  
            Statement stmt = conn.createStatement();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }  
  
    /** 
     * 关闭资源 
     * @param statement为执行命令的实例，connection为连接对象          
     */  
    public static void close(Statement statement, Connection connection) {  
        {  
            try {  
                if (statement != null)  
                    statement.close();  
                if (connection != null) {  
                    connection.close();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    /** 
     * 创建一个数据库表
     */  
    public void CreatTable() {  
        // 1.获取连接  
        Connection connection = SqlDB.getconnection();  
        // 2.准备sql语句  
        String sql = "CREATE TABLE student(sid INT PRIMARY KEY,sname VARCHAR(20),age INT)";  
        PreparedStatement preparedStatement = null;  
        // 3.获得对象  
        try {  
            preparedStatement = connection.prepareStatement(sql);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        // 4.交给数据库执行SQL  
        int num = 0;  
        try {  
            num = preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        System.out.println("有" + num + "条记录受到了影响");  
        SqlDB.close(preparedStatement, connection);  
    }  
    /** 
     * 执行插入操作 
     * @param 相应的参数     
     */  
    public void InsertData(int id, String name, int age) {  
        // 1.获取连接  
        Connection connection = SqlDB.getconnection();  
        // 2.准备sql语句  
        String sql = "INSERT INTO student VALUES(?,?,?)";  
        PreparedStatement preparedStatement = null;  
        // 3.获得对象  
        try {  
            preparedStatement = connection.prepareStatement(sql);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        // 4.设置SQL参数 需要参数是第几个，并且知道它的类型 下面第一句表示：SQL语句第一个参数是int类型，参数值设置为id，如此类推  
        try {  
            preparedStatement.setInt(1, id);  
            preparedStatement.setString(2, name);  
            preparedStatement.setInt(3, age);  
        } catch (SQLException e1) {  
            e1.printStackTrace();  
        }  
        // 5.交给数据库执行SQL  
        int num = 0;  
        try {  
            num = preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        System.out.println("有" + num + "条记录受到了影响");  
        SqlDB.close(preparedStatement, connection);  
  
    }  
    /** 
     * 执行查找操作 
     * @param  
     */  
    public void SelectDataWithId(int id) {  
        // 1.获取连接  
        Connection connection = SqlDB.getconnection();  
        // 2.准备sql语句  
        String sql = "SELECT * FROM book where bid=?";  
        PreparedStatement preparedStatement = null;  
        ResultSet res = null;  
        // 3.获得对象  
        try {  
            preparedStatement = connection.prepareStatement(sql);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        /* 
         * 4.设置SQL参数 需要参数是第几个，并且知道它的类型 下面第一句表示：SQL语句第一个参数是int类型，参数值设置为id，如此类推 
         */  
        try {  
            preparedStatement.setInt(1, id);  
        } catch (SQLException e1) {  
            e1.printStackTrace();  
        }  
        // 5.交给数据库执行SQL  
        try {  
            res = preparedStatement.executeQuery();  
            while (res.next()) {  
                // 先获取数据  
                int bid1= res.getInt("bid");  
                String bname = res.getString("bname");  
                int bcount = res.getInt("bcount");  
                // 打印结果  
                System.out.print("bid: " + bid1);  
                System.out.print("  bname: " + bname);  
                System.out.println("  bcount: " + bcount);  
            }  
        } catch (SQLException e1) {  
            e1.printStackTrace();  
        }  
        SqlDB.close(preparedStatement, connection);  
    }  
    
}

/**
 * Project Name:dt59homework
 * File Name:News.java
 * Package Name:news
 * Date:2018年4月7日上午12:11:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Description: <br/>
 * Date: 2018年4月7日 上午12:11:54 <br/>
 * 
 * @author sunhao
 * @version
 * @param <User_info>
 * @see
 */
/**
 * Description: <br/>
 * Date: 2018年4月7日 上午12:11:54 <br/>
 * 
 * @author sunhao
 * @version
 * @param <User_info>
 * @see
 */
public class News<User_info> {

    Connection con = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/news";

    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

}

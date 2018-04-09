/**
 * Project Name:neiz
 * File Name:BaseDao.java
 * Package Name:neiz.dao
 * Date:2018年4月3日下午3:16:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package neiz.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:16:25 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BaseDao {

    protected Connection con = null;

    protected PreparedStatement ps = null;

    protected ResultSet rs = null;

    static String url;

    static String driver;

    static String username;

    static String userpwd;
    static {
        init();
    }

    public static void init() {
        Properties pro = new Properties();
        String path = "database.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(path);
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            userpwd = pro.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getcon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, userpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public int contro(String sql, Object[] obj) {
        int flag = 0;
        try {
            ps = getcon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }
        return flag;
    }

    public void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Project Name:SIXwork
 * File Name:BaseDao.java
 * Package Name:m03.d28.sunhao
 * Date:2018年3月28日下午6:52:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.sunhao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午6:52:21 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class BaseDao {

    protected Connection con = null;

    protected PreparedStatement pst = null;

    protected ResultSet rs = null;

    static String driver;

    static String url;

    static String usename;

    static String password;
    static {
        init();
    }

    public static void init() {
        Properties pro = new Properties();
        String path = "database.properties";
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
            pro.load(ist);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            usename = pro.getProperty("usename");
            password = pro.getProperty("password");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usename, password);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public int controDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[1]);
                }
            }
            flag = pst.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public void close(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
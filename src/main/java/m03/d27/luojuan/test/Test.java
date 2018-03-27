/**
 * Project Name:jdbcZX
 * File Name:test.java
 * Package Name:test
 * Date:2018年3月27日下午5:17:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.luojuan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午5:17:34 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        Test tt = new Test();
        List<Ci> list = tt.getall();
        for (Ci ff : list) {
            System.out.println(ff.getCid() + "\t" + ff.getCname() + "\t" + ff.getPname());
        }
    }

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/mydata";

    // 连接
    public Connection getC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // 查询
    public List<Ci> getall() {
        List<Ci> li = new ArrayList<Ci>();
        String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
        try {
            ps = getC().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ci ff = new Ci();
                ff.setCid(rs.getInt("cid"));
                ff.setCname(rs.getString("cname"));
                // ff.setPid(rs.getInt("pid"));
                ff.setPname(rs.getString("pname"));
                li.add(ff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
}

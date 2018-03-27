/**
 * Project Name:lesson
 * File Name:jdbc.java
 * Package Name:JDBC
 * Date:2018年3月26日下午4:12:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lesson.src.JDBC.book;
/**
 * Description: <br/>
 * Date: 2018年3月26日 下午4:12:03 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class jdbc {
    public static void main(String[] args) {

        jdbc jj = new jdbc();
        List<book> list = jj.getAllInfo();
        for (book bk : list) {
            System.out.println(bk.getBid() + "\t" + bk.getBname() + "\t" + bk.getAuthor() + "\t" + bk.getPubcomp()
                    + "\t" + bk.getPubDate() + "\t" + bk.getBcount() + "\t" + bk.getPrice());
        }

    }

    Connection con = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/library";

    public Connection getcon() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return con;
    }

    public List<book> getAllInfo() {
        List<book> list = new ArrayList<book>();
        try {
            String sql = "SELECT * FROM book";
            pst = getcon().prepareStatement(sql);
            // 执行
            rs = pst.executeQuery();
            while (rs.next()) {
                book bk = new book();
                bk.setBid(rs.getInt("bid"));
                bk.setBname(rs.getString("bname"));
                bk.setBname(rs.getString("author"));
                bk.setBname(rs.getString("pubcomp"));
                bk.setBname(rs.getString("pubDate"));
                bk.setBid(rs.getInt("bcount"));
                bk.setBid(rs.getInt("price"));
                list.add(bk);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

}

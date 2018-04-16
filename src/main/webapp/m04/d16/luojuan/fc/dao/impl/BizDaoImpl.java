/**
 * Project Name:PinHong
 * File Name:BizDaoImpl.java
 * Package Name:fc.dao.impl
 * Date:2018年4月12日下午7:22:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fc.dao.BaseDao;
import fc.dao.BizDao;
import fc.entity.News;
import fc.entity.Page;
import fc.entity.Product;
import fc.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:22:38 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<News> getAllNews() {
        List<News> listnews = new ArrayList<News>();
        try {
            String sql = "SELECT * FROM news";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                News ns = new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setNdate(rs.getDate(4));
                listnews.add(ns);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> listpro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listpro.add(pro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listpro;
    }

    @Override
    public boolean validateUser(User user) {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM USER";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));
                user.setUpic(rs.getString(5));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listUser;
    }

    @Override
    public String getUserRoleByName(String name, String pwd) {
        String role = "";
        try {
            String sql = "SELECT user.`ustatus` FROM USER WHERE uname=? AND upwd=?;";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pwd);
            rs = pst.executeQuery();
            while (rs.next()) {
                role = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return role;
    }

    @Override
    public List<Product> getAllProductByPage(Page page) {
        List<Product> listpro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product LIMIT ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, page.getCurrentpage() - 1 * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPpicture(rs.getString(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listpro;
    }

    @Override
    public int getProductNumber() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(1) FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return count;
    }

}

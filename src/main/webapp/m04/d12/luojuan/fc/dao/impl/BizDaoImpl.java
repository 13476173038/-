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
import fc.entity.Product;

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

}

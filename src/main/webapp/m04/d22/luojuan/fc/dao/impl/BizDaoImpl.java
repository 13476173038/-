/**
 * Project Name:Shopping
 * File Name:BizDaoImpl.java
 * Package Name:fc.dao.impl
 * Date:2018年4月19日下午12:17:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fc.dao.BaseDao;
import fc.dao.BizDao;
import fc.entity.Shangping;
import fc.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:17:01 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<Shangping> getAllShanping() {
        List<Shangping> listsp = new ArrayList<Shangping>();
        try {
            String sql = "SELECT * FROM shangping";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Shangping sp = new Shangping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getFloat(3));
                sp.setSpdesc(rs.getString(4));
                listsp.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listsp;
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
    public Shangping getShangpingById(int id) {
        Shangping sp = null;
        try {
            String sql = "SELECT * FROM shangping WHERE spid=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp = new Shangping();
                sp.setSpprice(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getFloat(3));
                sp.setSpdesc(rs.getString(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        return sp;
    }

}

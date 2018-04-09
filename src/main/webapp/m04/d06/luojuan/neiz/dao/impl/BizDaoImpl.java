/**
 * Project Name:neiz
 * File Name:BizDaoImpl.java
 * Package Name:neiz.dao.impl
 * Date:2018年4月3日下午4:01:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package neiz.dao.impl;

import neiz.dao.BaseDao;
import neiz.dao.BizDao;
import neiz.entity.UInfo;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:01:42 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    public boolean validateUser(UInfo user) {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info a WHERE a.username=? AND a.password=?";
            ps = getcon().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }
        return false;
    }
}

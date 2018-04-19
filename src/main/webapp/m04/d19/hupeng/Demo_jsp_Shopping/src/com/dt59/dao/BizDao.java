/**
 * Project Name:Demo_jsp_Shopping
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月19日下午12:04:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.User;
import com.dt59.entity.shangping;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:04:35 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public interface BizDao {
    List<shangping> getAllShangpings();
    boolean validateUser(User user);
    shangping getShangpingById(int id);
}


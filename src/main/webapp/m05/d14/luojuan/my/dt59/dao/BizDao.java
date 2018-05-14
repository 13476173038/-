/**
 * Project Name:mybatis01
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日上午11:05:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午11:05:33 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public interface BizDao {
    List<Stu> getStu();
}

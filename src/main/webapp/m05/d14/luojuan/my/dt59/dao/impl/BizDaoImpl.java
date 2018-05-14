/**
 * Project Name:mybatis01
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年5月14日上午11:14:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午11:14:11 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizDaoImpl implements BizDao {

    @Override
    public List<Stu> getStu() {
        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();
        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();
        SqlSession sqlsession = ssf.openSession();
        List<Stu> list = sqlsession.selectList("sqlmapper.getStu");
        return null;
    }

}

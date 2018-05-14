/**
 * Project Name:mybatis01
 * File Name:GetSqlSessionutil.java
 * Package Name:com.dt59.util
 * Date:2018年5月14日上午11:19:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午11:19:38 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class GetSqlSessionUtil {
    static SqlSessionFactory ssf = null;

    public static GetSqlSessionUtil gsu = null;

    private GetSqlSessionUtil() {
    };

    public static GetSqlSessionUtil getInstance() {
        if (gsu == null) {
            gsu = new GetSqlSessionUtil();
        }
        return gsu;
    }

    public static SqlSessionFactory getsqlsessionfactory_() {
        if (ssf == null) {
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                ssf = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ssf;
    }
}

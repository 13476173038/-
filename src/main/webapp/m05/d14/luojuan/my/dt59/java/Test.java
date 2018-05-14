/**
 * Project Name:mybatis01
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年5月14日上午11:37:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.List;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午11:37:10 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        BizDaoImpl bdi = new BizDaoImpl();
        List<Stu> list = bdi.getStu();
        for (Stu stu : list) {
            System.out.println(stu.getSid() + " " + stu.getSname() + " " + stu.getSage() + " " + stu.getScard() + " "
                    + stu.getSgid());
        }
    }

}

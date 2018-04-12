/**
 * Project Name:dt59_pinghong
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018��4��12������7:24:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.News;
import com.dt59.entity.Product;

/**
 * Description: <br/>
 * Date: 2018��4��12�� ����7:24:50 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProduct();
}

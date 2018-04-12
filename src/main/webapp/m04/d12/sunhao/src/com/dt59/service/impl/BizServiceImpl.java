/**
 * Project Name:dt59_pinghong
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月12日下午7:49:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:49:09 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    public List<News> getAllNews() {

        // Auto-generated method stub
        return bizDao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {

        // Auto-generated method stub
        return bizDao.getAllProduct();
    }

}

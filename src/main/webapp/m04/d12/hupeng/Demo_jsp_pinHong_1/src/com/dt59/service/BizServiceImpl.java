/**
 * Project Name:Demo_jsp_pinHong_1
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service
 * Date:2018年4月12日下午10:20:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午10:20:06 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class BizServiceImpl implements  BizService{
    @Override
	public List<Product> getAllProduct() {
		
		//  Auto-generated method stub
		return bizDao.getAllProduct();
	}
	private BizDao bizDao;
    public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}
	@Override
	public List<News> getAllNews() {
		
		//  Auto-generated method stub
		return bizDao.getAllNews();
	}

	

}


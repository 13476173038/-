package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService {
	private BizDao bizDao;
	public BizDao getBizDao() {
		return bizDao;
	}
	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return bizDao.getAllNews();
	}
	
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return bizDao.getAllProduct();
	}
	
}

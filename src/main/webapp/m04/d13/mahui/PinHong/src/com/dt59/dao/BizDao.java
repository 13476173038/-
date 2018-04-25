package com.dt59.dao;

import java.util.List;

import com.dt59.entity.News;
import com.dt59.entity.Product;

public interface BizDao {
	List<News> getAllNews();
	List<Product> getAllProduct();
}

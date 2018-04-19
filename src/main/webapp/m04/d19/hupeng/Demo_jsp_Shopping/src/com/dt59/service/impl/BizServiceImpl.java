/**
 * Project Name:Demo_jsp_Shopping
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月19日下午2:17:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.User;
import com.dt59.entity.shangping;
import com.dt59.service.BizService;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午2:17:43 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class BizServiceImpl implements BizService{
    private BizDao bizdao;
	

	public BizDao getBizdao() {
		return bizdao;
	}

	public void setBizdao(BizDao bizdao) {
		this.bizdao = bizdao;
	}
    @Override	
	public List<shangping> getAllShangpings() {
		
		//  Auto-generated method stub
		return bizdao.getAllShangpings();
	}

	@Override
	public boolean validateUser(User user) {
		
		//  Auto-generated method stub
		return bizdao.validateUser(user);
	}

	

	@Override
	public shangping getShangpingById(int id) {
		
		//  Auto-generated method stub
		return bizdao.getShangpingById(id);
	}

	

	

}


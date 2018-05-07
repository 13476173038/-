package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService {
	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(user);
	}


	public List<NewsInfo> getNewsInfo() {
		// TODO Auto-generated method stub
		return bizDao.getNewsInfo();
	}

	@Override
	public List<CommentInfo> getCommentInfo() {
		// TODO Auto-generated method stub
		return bizDao.getCommentInfo();
	}

	@Override
	public List<NewsInfo> getNewsByPage(Page pg) {
		// TODO Auto-generated method stub
		return bizDao.getNewsByPage(pg);
	}

	public int getInfoCount() {
		// TODO Auto-generated method stub
		return bizDao.getInfoCount();
	}

}

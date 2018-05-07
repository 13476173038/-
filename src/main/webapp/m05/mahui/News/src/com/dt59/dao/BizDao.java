package com.dt59.dao;

import java.util.List;

import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;

public interface BizDao {

	boolean validateUser(UserInfo user);
	
	List<NewsInfo> getNewsInfo();
	
	List<CommentInfo> getCommentInfo();
	
	List<NewsInfo> getNewsByPage(Page pg);
	
	int getInfoCount();
	
	
}

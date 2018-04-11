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

    @Override
    public boolean validateUser(UserInfo user) {
        // TODO Auto-generated method stub
        return bizDao.validateUser(user);
    }

    @Override
    public List<NewsInfo> getNews() {
        // TODO Auto-generated method stub
        return bizDao.getNews();
    }

    @Override
    public List<NewsInfo> getNewsInfobyPage(Page page) {

        // Auto-generated method stub
        return bizDao.getNewsInfobyPage(page);
    }

    @Override
    public int delNewsInfoById(int id) {
        // TODO Auto-generated method stub
        return bizDao.delNewsInfoById(id);
    }

    @Override
    public int updateNewsInfo(NewsInfo info) {
        // TODO Auto-generated method stub
        return bizDao.updateNewsInfo(info);
    }

    @Override
    public List<CommentInfo> getAllCommentInfo() {
        // TODO Auto-generated method stub
        return bizDao.getAllCommentInfo();
    }

}

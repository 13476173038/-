package impl;

import java.util.List;

import dao.BizDao;
import entity.CommentInfo;
import entity.NewsInfo;
import entity.UserInfo;

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

    public List<NewsInfo> getNews() {
        // TODO Auto-generated method stub
        return bizDao.getNews();
    }

    public int delNewsInfoById(int id) {
        // TODO Auto-generated method stub
        return bizDao.delNewsInfoById(id);
    }

    public int updateNewsInfo(NewsInfo info) {
        // TODO Auto-generated method stub
        return bizDao.updateNewsInfo(info);
    }

    public List<CommentInfo> getAllCommentInfo() {
        // TODO Auto-generated method stub
        return bizDao.getAllCommentInfo();
    }

}

package dao;

import java.util.List;

import entity.CommentInfo;
import entity.NewsInfo;
import entity.UserInfo;

public interface BizDao {
    boolean validateUser(UserInfo user);

    List<NewsInfo> getNews();

    int delNewsInfoById(int id);

    int updateNewsInfo(NewsInfo info);

    List<CommentInfo> getAllCommentInfo();
}

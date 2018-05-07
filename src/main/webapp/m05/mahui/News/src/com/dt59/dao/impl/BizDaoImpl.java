package com.dt59.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

	
	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="SELECT * FROM user_info a WHERE a.username=? AND a.password=?";
		try {
			pst=getCon().prepareStatement(sql);
			pst.setString(1,user.getUsername());
			pst.setString(2,user.getPassword());
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(con, pst, rs);
		}
		return flag;
	}

	
	public List<NewsInfo> getNewsInfo() {
		// TODO Auto-generated method stub
		List<NewsInfo> listnews=new ArrayList<NewsInfo>();
		String sql="SELECT news_title,news_author FROM news_info ";
		try {
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				NewsInfo news=new NewsInfo();
				news.setNews_title(rs.getString(1));
				news.setNews_author(rs.getString(2));
				listnews.add(news);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(con, pst, rs);
		}
		return listnews;
	}


	public List<CommentInfo> getCommentInfo() {
		// TODO Auto-generated method stub
		List<CommentInfo> commentInfo=new ArrayList<CommentInfo>();
		String sql="SELECT content,fbtime FROM comment_info";
		try {
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
			CommentInfo comment=new CommentInfo();
			comment.setComment(rs.getString(1));
			comment.setFbtime(rs.getDate(2));
			commentInfo.add(comment);			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(con, pst, rs);
		}
		
		return commentInfo;
	}


	@Override
	public List<NewsInfo> getNewsByPage(Page pg) {
		// TODO Auto-generated method stub
		List<NewsInfo> newsInfo=new ArrayList<NewsInfo>();
		String sql="SELECT * FROM news_info LIMIT ?,?";
		try {
			pst=getCon().prepareStatement(sql);
			pst.setInt(1,( pg.getPageNo()-1)*3);
			pst.setInt(2, 3);
			rs=pst.executeQuery();
			while(rs.next()){
				NewsInfo news=new NewsInfo();
				news.setNews_id(rs.getInt(1));
				news.setType_id(rs.getInt(2));
				news.setNews_title(rs.getString(3));
				news.setNews_author(rs.getString(4));
				news.setNews_summary(rs.getString(5));
				news.setNews_content(rs.getString(6));
				news.setNews_pic(rs.getString(7));
				newsInfo.add(news);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(con, pst, rs);
		}
		return newsInfo;
	}


	public int getInfoCount() {
		// TODO Auto-generated method stub
		int totalInfo=0;
		String sql="SELECT COUNT(1) FROM news_info";
		try {
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				totalInfo=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(con, pst, rs);
		}
		return totalInfo;
	}

}

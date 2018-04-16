package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.entity.User;

public class BizDaoImpl extends BaseDao implements BizDao{

	@Override
	public List<User> getAllUser() {
		
		//  Auto-generated method stub
		return null;
	}

	@Override
	public String getUserRoleByName(String name, String pwd) {
		
		 //  Auto-generated method stub
		String role="";
		try {
			String sql="";
			pst=getCon().prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			rs=pst.executeQuery();
			while(rs.next()){
				role=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return role;
	}

	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		List<News> listnews=new ArrayList<News>();
		try {
			String sql="SELECT * FROM news";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				News ns=new News();
				ns.setNid(rs.getInt(1));
				ns.setNtitle(rs.getString(2));
				ns.setNcontent(rs.getString(3));
				ns.setNdate(rs.getDate(4));
				listnews.add(ns);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listnews;
	}

	public List<Product> getAllProduct() {
		List<Product> listpro=new ArrayList<Product>();
		try {
			String sql="SELECT * FROM product";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setPid(rs.getInt(1));
				pro.setPname(rs.getString(2));
				pro.setPbrand(rs.getString(3));
				pro.setPmodel(rs.getString(4));
				pro.setPprice(rs.getDouble(5));
				pro.setPpicture(rs.getString(6));
				pro.setPdesc(rs.getString(7));
				listpro.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listpro;
	}

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
			pst= getCon().prepareStatement(sql);
			pst.setString(1, user.getUname());
			pst.setString(2, user.getUpwd());
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

}

package com.dt59.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;

public class BizDaoImpl extends BaseDao implements BizDao{

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		List<News> info=new ArrayList<News>();
		String sql="SELECT * FROM news";
		try {
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs!=null){
				News ns=new News();
				 ns.setNid(rs.getInt(1));
				 ns.setNtitle(rs.getString(2));
				 ns.setNcontent(rs.getString(3));
				 ns.setNdate(rs.getDate(4));
				 info.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> proinfo=new ArrayList<Product>();
		String sql="SELECT * FROM product";
		try {
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs!=null){
				Product pro=new Product();
				 pro.setPid(rs.getInt(1));
				 pro.setPname(rs.getString(2));
				 pro.setPbrand(rs.getString(3));
				 pro.setPmodel(rs.getString(4));
				 pro.setPprice(rs.getDouble(5));
				 pro.setPpicture(rs.getString(6));
				 proinfo.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proinfo;
	}

	
}

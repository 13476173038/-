/**
 * Project Name:Demo_jsp_Shopping
 * File Name:BizDaoimpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月19日下午12:10:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.User;
import com.dt59.entity.shangping;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午12:10:16 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao  implements  BizDao{

	@Override
	public List<shangping> getAllShangpings() {
		
		//  Auto-generated method stub
		List<shangping> listsp=new ArrayList<shangping>();
		try {
			String sql="SELECT * FROM shangping";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				shangping sp=new shangping();
				sp.setSpid(rs.getInt(1));
				sp.setSpname(rs.getString(2));
				sp.setSpprice(rs.getFloat(3));
				sp.setSpdesc(rs.getString(4));				
				listsp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listsp;
	}

	@Override
	public boolean validateUser(User user){
		
		//  Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM USER  WHERE uname=?  AND upwd=? ";
			pst= getCon().prepareStatement(sql);
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

	@Override
	public shangping getShangpingById(int id) {
		
		//  Auto-generated method stub
		shangping sp=null;
		
		try {
			String sql="SELECT * FROM shangping  WHERE  spid=?";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
			    sp=new shangping();
				sp.setSpid(rs.getInt(1));
				sp.setSpname(rs.getString(2));
				sp.setSpprice(rs.getFloat(3));
				sp.setSpdesc(rs.getString(4));				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return sp;
	}
}


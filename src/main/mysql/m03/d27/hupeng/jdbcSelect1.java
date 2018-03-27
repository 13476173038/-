/**
 * Project Name:LianXi.Demo
 * File Name:jdbcSelect1.java
 * Package Name:jdbc
 * Date:2018年3月27日下午8:30:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月27日 下午8:30:09 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class jdbcSelect1 {
	public static void main(String[] args) {
		jdbcSelect1  jbs=new jdbcSelect1();
		List<ProvinceCity> list=jbs.getAllProvince();
		for (ProvinceCity p : list) {
			System.out.println(p.getCid()+p.getCname()+p.getPname());
		}
		
	}
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet  rs=null;
	private String url="jdbc:mysql://localhost:3306/mydata";
	
	public Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, "root","root");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return con;
		
	}
	public List<ProvinceCity>  getAllProvince(){
		List<ProvinceCity>  list=new ArrayList<ProvinceCity>(); 
		try {
			String sql="SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				ProvinceCity p=new 	ProvinceCity();
				p.setCid(rs.getInt("cid"));
				p.setCname(rs.getString("cname"));
				p.setPname(rs.getString("pname"));
				p.setC_pid(rs.getInt("c_pid"));
				p.setP_pid(rs.getInt("p_pid"));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exceptio
			e.printStackTrace();
  
		}finally{
			close(con,pst,rs);
		}
		return list;
	}
	private void close(Connection con, PreparedStatement pst, ResultSet rs) {
	
			try {
				if (null!=con) {
				con.close();
				}if (null !=pst) {
					pst.close();
				}if (null !=rs) {
					rs.close();
				}
			} catch (SQLException e) {
				
				
				e.printStackTrace();
				
			}
		
	}

}


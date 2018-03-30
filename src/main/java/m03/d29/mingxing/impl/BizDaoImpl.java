package m03.d29.mingxing.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import m03.d29.mingxing.dao.BizDao;
import m03.d29.mingxing.reader.reader;


public class BizDaoImpl implements BizDao{

	@Override
	public int zhen(reader reader) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shan(reader reader) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int gai(reader reader) {
		Connection con = null;
		PreparedStatement pst = null;
		String url = "jdbc:mysql://localhost:3306/library";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, "root", "root");
			pst = con.prepareStatement("update reader set rname=? where rid=?");
			pst.setString(1,reader.getRname());
			pst.setString(2,reader.getRid());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return 0;
	}

	@Override
	public int cha(reader reader) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

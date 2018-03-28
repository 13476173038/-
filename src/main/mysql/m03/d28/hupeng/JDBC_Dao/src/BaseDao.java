import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Project Name:JDBC_Dao
 * File Name:BaseDao.java
 * Package Name:
 * Date:2018年3月28日下午3:12:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:12:36 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class BaseDao {
	protected Connection con=null;
	protected PreparedStatement pst=null;
	protected ResultSet rs=null;
	static String driver;
	static String url;
	static String username;
	static String password;
	static{
		init();
	}
	public static void init(){
		Properties pro=new Properties();
		//配置文件路径
		String path="database.properties";
		try {
			//配置文件加载到输入流
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(path);
			//从输入流中读取属性列表
			pro.load(is);
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			username=pro.getProperty("username");
			password=pro.getProperty("password");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	  public Connection getCon(){
		  
		  try {
			 Class.forName(driver);
			 con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	  }
	  public int controlDml(String sql,Object obj[]){
		  int flage=0;
		  try {
			pst=getCon().prepareStatement(sql);
			if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i+1, obj[i]);
				}
			}
			flage=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs,pst,con);
		}
		return flage;
		
		  
	  }
	  
	public  void close(ResultSet rs, PreparedStatement pst, Connection con){
		  try {
			if (null!=rs) {
				rs.close();
			}if (null!=pst) {
				pst.close();
			}if (null!=con) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   
	  }
	  

}


package mysqlch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Infotest.Info;

public class test {
	public static void main(String[] args) {
		test tt = new test();
		List<Info> list = tt.getAllInfo();
		for (Info ff : list) {
			System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
		}
	}
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private String url="jdbc:mysql://localhost:3306/mydata";
	//链接方法
	public Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
public List<Info> getAllInfo(){
		List<Info> list = new ArrayList<Info>();
		try {
			String sql = "SELECT * FROM info";
			pst = getCon().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Info ff = new Info();
				ff.setId(rs.getInt("id"));
				ff.setName(rs.getString("name"));
				ff.setAge(rs.getInt("age"));
				list.add(ff);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
}
	//查询的方法
	

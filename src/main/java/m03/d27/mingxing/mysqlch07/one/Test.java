package mysqlch07.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mysqlch07.one.entity.Student;

public class Test {
	public static void main(String[] args) {
		Test tt = new Test();
		List<Student> list = tt.getAllStudent();
		for(Student stu : list){
			System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要更改的名字");
		String name = sc.next();
		System.out.println("请输入年龄");
		int id = sc.nextInt();
		int flag = tt.updateStudent(id, name);
		System.out.println("修改的结果:"+flag);
	}
	Connection con = null;
	Statement stt = null;
	ResultSet rs = null;
	private String url = "jdbc:mysql://localhost:3306/mydata";
	public Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	    }
	public void close(Connection con,Statement stt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stt!=null){
				stt.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
}
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		try {
			String sql = "SELECT * FROM info";
			stt = getCon().createStatement();
			rs = stt.executeQuery(sql);
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setAge(rs.getString(3));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,stt,rs);
		}
		return list;
	}
	public int updateStudent(int id,String str){
		int flag = 0;
		try {
			String sql  ="UPDATE info SET name='"+str+"' WHERE id="+id;
			stt = getCon().createStatement();
			flag = stt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,stt,rs);
		}
		return flag;
	}
	
}

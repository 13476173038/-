package cn.bird.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSessionUtil {
	static SqlSessionFactory ssf=null;
	public static GetSqlSessionUtil gsu=null;
	private GetSqlSessionUtil(){}
	public static GetSqlSessionUtil getInstance(){
		if(gsu==null){
			gsu=new GetSqlSessionUtil();
		}
		return gsu;
	}
	public static SqlSessionFactory  getsqlsessionfactory_(){
		InputStream inputStream;
		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			ssf= new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssf;
	}
}

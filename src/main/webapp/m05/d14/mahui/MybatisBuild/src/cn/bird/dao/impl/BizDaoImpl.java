package cn.bird.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.bird.dao.BizDao;
import cn.bird.pojo.Book;
import cn.bird.util.GetSqlSessionUtil;

public class BizDaoImpl implements BizDao {
	GetSqlSessionUtil gsu=GetSqlSessionUtil.getInstance();
	SqlSessionFactory ssf=gsu.getsqlsessionfactory_();
	SqlSession sqlsession=ssf.openSession();

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> list=null;
		try{
			list=sqlsession.selectList("SqlMapper.getBooks");
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			sqlsession.close();
		}
		return list;
	}

	Book book=null;
	public Book getBookbyId(int bid) {
		// TODO Auto-generated method stub
		try{
			book=sqlsession.selectOne("SqlMapper.getBookbyId", bid);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			sqlsession.close();
		}
		return book;
	}

	public Book getBookbyMap(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		try{
			book=sqlsession.selectOne("SqlMapper.getBookbyMap", map);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			sqlsession.close();
		}
		return book;
	}

	public Book getBookbyEntity(Book book) {
		// TODO Auto-generated method stub
		try{
			book=sqlsession.selectOne("SqlMapper.getBookbyMap", book);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			sqlsession.close();
		}
		return book;
	}

	public List<HashMap<String, Object>> getBorrowInfo() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> list=null;
		try{
			list=sqlsession.selectList("SqlMapper.getBooksInfo");
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			sqlsession.close();
		}
		return list;
	}

}

package cn.bird.dao;

import java.util.HashMap;
import java.util.List;

import com.sun.xml.internal.ws.client.Stub;

import cn.bird.pojo.Book;

public interface BizDao {
	List<Book> getBooks();
	Book getBookbyId(int bid);
	Book getBookbyMap(HashMap<String,Object> map);
	Book getBookbyEntity(Book book);
	List<HashMap<String, Object>> getBorrowInfo();
}

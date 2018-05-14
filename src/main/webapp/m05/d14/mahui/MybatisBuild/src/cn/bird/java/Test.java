package cn.bird.java;

import java.util.List;
import java.util.Scanner;

import cn.bird.dao.impl.BizDaoImpl;
import cn.bird.pojo.Book;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BizDaoImpl bdi=new BizDaoImpl();
		List<Book> list=bdi.getBooks();
	for (Book book : list) {
		System.out.println(book.getBid()+"\t"+book.getBname()+"\t"+book.getBpubTime());
	}
	
	}
}

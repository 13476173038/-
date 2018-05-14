package cn.bird.java;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import cn.bird.dao.impl.BizDaoImpl;
import cn.bird.pojo.Book;

public class Demo1 {
	BizDaoImpl bdi=new BizDaoImpl();
	@Test
	public void show1(){
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入图书编号:");
		int num=sc.nextInt();
		Book book1=bdi.getBookbyId(num);
		System.out.println(book1.getBid()+"\t"+book1.getBname()+"\t"+book1.getBpubTime());
				
	}
	@Test
	public void show2(){
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("bid", 105);
		map.put("bname", "平凡的世界");
		Book book2=bdi.getBookbyMap(map);
		System.out.println(book2.getBid()+"\t"+book2.getBname()+"\t"+book2.getBpubTime());
		
	}
	@Test
	public void show3(){
		Book book=new Book();
		book.setBid(105);
		book.setBname("平凡的世界");
		Book book2=bdi.getBookbyEntity(book);
		System.out.println(book2.getBid()+"\t"+book2.getBname()+"\t"+book2.getBpubTime());
		
	}
	@Test
	public void show4(){
		List<HashMap<String, Object>> list=bdi.getBorrowInfo();
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> map=list.get(i);
			Set<String> keys=map.keySet();
			for (String kk : keys) {
				System.out.println(kk+"\t"+map.get(kk));
			}
		}
		
	}
}

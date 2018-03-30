package m03.d29.mingxing.java;

import m03.d29.mingxing.dao.BizDao;
import m03.d29.mingxing.impl.BizDaoImpl;
import m03.d29.mingxing.reader.reader;


public class Test {
	public static void main(String[] args) {
		BizDao dao = new BizDaoImpl();
		reader r = new reader();
		r.setRname("��ƨ����");
		r.setRid("0010");
		dao.gai(r);
	}
}

package com.dt59.java;

import com.dt59.dao.impl.BizDaoImpl;

public class Test01 {

	/**
	 * ���ܣ����ô洢���� 
	 */
	public static void main(String[] args) {
		
		BizDaoImpl bdi=new BizDaoImpl();
		bdi.callprocedure2(10, 30);
	}

}

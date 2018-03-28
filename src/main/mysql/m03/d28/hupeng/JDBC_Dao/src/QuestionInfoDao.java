import java.util.List;




/**
 * Project Name:JDBC_Dao
 * File Name:QuestionInfoDao.java
 * Package Name:
 * Date:2018年3月28日下午3:12:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:12:52 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
	//获取所有 
	void getAll();
	//按科目查询试题
	void selectsubject();
	//按题干模糊查询试题
	List<QuestionInfo> select_t(String t);
	//添加试题
	void insert();
	//删除试题
	 boolean delete(int choose);
	//按试题编号查询试题
	 void selectQuestionId();

}


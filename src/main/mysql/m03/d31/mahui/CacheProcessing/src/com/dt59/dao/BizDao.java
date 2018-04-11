package com.dt59.dao;

import java.util.List;

import com.dt59.entity.QuestionInfo;


public interface BizDao {
	List<QuestionInfo> getAllQuestionInfo();//列出所有试题信息
	List<QuestionInfo> getQuestionInfoByKm(int subject);//按科目查询
	List<QuestionInfo> getQuestionInfoByTg(String title);//按题干模糊查询
	int saveQuestionInfo(QuestionInfo info);//添加试题
	int deleteQuestionInfoById(int id);//通过id删除
	void exitQuestion();
	
	void callprocedure();
	
	void callprocedure2(int a,int b);
	
}

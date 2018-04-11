package com.dt59.dao;

import java.util.List;

import com.dt59.entity.QuestionInfo;


public interface BizDao {
	List<QuestionInfo> getAllQuestionInfo();//�г�����������Ϣ
	List<QuestionInfo> getQuestionInfoByKm(int subject);//����Ŀ��ѯ
	List<QuestionInfo> getQuestionInfoByTg(String title);//�����ģ����ѯ
	int saveQuestionInfo(QuestionInfo info);//�������
	int deleteQuestionInfoById(int id);//ͨ��idɾ��
	void exitQuestion();
	
	void callprocedure();
	
	void callprocedure2(int a,int b);
	
}

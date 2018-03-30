package com.bluebird.dao;

import java.util.List;

import com.bluebird.entity.QuestionInfo;

/**
 * 1)�г�����������Ϣ
		2)����Ŀ��ѯ
		3)�����ģ����ѯ
		4)�������
		5)ɾ������
		6)�˳�ϵͳ
 * */
public interface BizDao {
	List<QuestionInfo> getAllQuestionInfo();//�г�����������Ϣ
	List<QuestionInfo> getQuestionInfoByKm(int subject);//����Ŀ��ѯ
	List<QuestionInfo> getQuestionInfoByTg(String title);//�����ģ����ѯ
	int insertQuestionInfo(QuestionInfo info);//�������
	int deleteQuestionInfoById(int id);//ͨ��idɾ��
	void exitQuestion();
}

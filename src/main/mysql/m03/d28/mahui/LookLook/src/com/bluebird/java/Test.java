package com.bluebird.java;

import java.util.List;
import java.util.Scanner;

import com.bluebird.dao.BizDao;
import com.bluebird.dao.impl.BizDaoImpl;
import com.bluebird.entity.QuestionInfo;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.init();
	}
	Scanner sc=new Scanner(System.in);
	public void init(){
		
		String tt="";
		do{
			System.out.println("=======================������Ϣ����ϵͳ���˵�=======================");
			System.out.println("\t1)�г�����������Ϣ  2)����Ŀ��ѯ  3)�����ģ����ѯ 4)�������  5)ɾ������  6)�˳�ϵͳ");
			System.out.println("��ѡ��:");
			int flag=sc.nextInt();
			if(flag>=1&&flag<=6){
				switch(flag){
					case 1:
						//�г�����������Ϣ
						showAllQuestionInfo();
						break;
					case 2:
						searchSubject();
						break;
					case 3:
						searchByTg();
						break;
					case 4:
						addQuestionInfo();
						break;
					case 5:
						deleteById();
						break;
					case 6:
						bizdao.exitQuestion();
						break;
				}
			}
			
			System.out.println("�Ƿ������(y/n)");
			tt=sc.next();
		}while(tt.equals("y"));
		
	}
	BizDao bizdao=new BizDaoImpl();//����ת��
	/**
	 * �г�����������Ϣ
	 * */
	public void showAllQuestionInfo(){
		List<QuestionInfo> listinfo= bizdao.getAllQuestionInfo();
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	/**
	 * ����Ŀ��ѯ
	 * */
	public void searchSubject(){
		System.out.println("======================����Ŀ��ѯ======================");
		System.out.println("�������Ŀ���:");
		int subject=sc.nextInt();
		List<QuestionInfo> listinfo=bizdao.getQuestionInfoByKm(subject);
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	
	public void searchByTg(){
		System.out.println("======================�����ģ����ѯ======================");
		System.out.println("���������:");
		String str=sc.next();
		List<QuestionInfo> listinfo=bizdao.getQuestionInfoByTg(str);
		for(int i=0;i<listinfo.size();i++){
			QuestionInfo info=listinfo.get(i);
			System.out.println(info.getQuestionId()+"."+info.getQuestion());
			System.out.println("\t"+info.getOptionA());
			System.out.println("\t"+info.getOptionB());
			System.out.println("\t"+info.getOptionC());
			System.out.println("\t"+info.getOptionD());
			System.out.println("\t"+info.getAnswer());
		}
	}
	
	public void addQuestionInfo(){
		QuestionInfo qinfo=new QuestionInfo();
		System.out.println("============================�����Ŀ=============================");
		System.out.println("��������ɣ�");
		qinfo.setQuestion(sc.next());
		System.out.println("������A��:");
		qinfo.setOptionA(sc.next());
		System.out.println("������B��:");
		qinfo.setOptionB(sc.next());
		System.out.println("������C��:");
		qinfo.setOptionC(sc.next());
		System.out.println("������D��:");
		qinfo.setOptionD(sc.next());
		System.out.println("�������Ŀ��ţ�");
		qinfo.setSubject(sc.nextInt());
		System.out.println("��������ȷ��:");
		qinfo.setAnswer(sc.next());
		int flag= bizdao.insertQuestionInfo(qinfo);
		if(flag>0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		}
	}
	
	public void deleteById(){
		System.out.println("============================ɾ��=============================");
		System.out.println("������Ҫɾ����ţ�");
		int id=sc.nextInt();
		int flag=bizdao.deleteQuestionInfoById(id);
		if(flag>0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
}

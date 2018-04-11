package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.QuestionInfo;

public class BizDaoImpl extends BaseDao implements BizDao{

	@Override
	public List<QuestionInfo> getAllQuestionInfo() {
		List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
		try {
			String sql="SELECT * FROM question_info";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				QuestionInfo info=new QuestionInfo();
				info.setQuestionId(rs.getInt(1));
				info.setQuestion(rs.getString(2));
				info.setOptionA(rs.getString(3));
				info.setOptionB(rs.getString(4));
				info.setOptionC(rs.getString(5));
				info.setOptionD(rs.getString(6));
				info.setSubject(rs.getInt(7));
				info.setAnswer(rs.getString(8));
				listinfo.add(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listinfo;
	}

	public List<QuestionInfo> getQuestionInfoByKm(int subject) {
		List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
		try {
			String sql="SELECT * FROM question_info WHERE SUBJECT = ?";
			pst= getCon().prepareStatement(sql);
			//赋值
			pst.setInt(1, subject);
			rs=pst.executeQuery();
			while(rs.next()){
				QuestionInfo info=new QuestionInfo();
				info.setQuestionId(rs.getInt(1));
				info.setQuestion(rs.getString(2));
				info.setOptionA(rs.getString(3));
				info.setOptionB(rs.getString(4));
				info.setOptionC(rs.getString(5));
				info.setOptionD(rs.getString(6));
				info.setSubject(rs.getInt(7));
				info.setAnswer(rs.getString(8));
				listinfo.add(info);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listinfo;
	}

	@Override
	public List<QuestionInfo> getQuestionInfoByTg(String title) {
		List<QuestionInfo> listinfo=new ArrayList<QuestionInfo>();
		try {
			String sql="SELECT * FROM question_info WHERE question LIKE ?";
			pst=getCon().prepareStatement(sql);
			//赋值
			pst.setString(1, "%"+title+"%");
			rs=pst.executeQuery();
			while(rs.next()){
				QuestionInfo info=new QuestionInfo();
				info.setQuestionId(rs.getInt(1));
				info.setQuestion(rs.getString(2));
				info.setOptionA(rs.getString(3));
				info.setOptionB(rs.getString(4));
				info.setOptionC(rs.getString(5));
				info.setOptionD(rs.getString(6));
				info.setSubject(rs.getInt(7));
				info.setAnswer(rs.getString(8));
				listinfo.add(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listinfo;
	}

	public int saveQuestionInfo(QuestionInfo info) {
		int flag=0;
		try {
			String sql="INSERT INTO question_info(Question,optionA,optionB,optionC,optionD,SUBJECT,answer) VALUES(?,?,?,?,?,?,?)";
			Object[] obj=new Object[7];
			obj[0]=info.getQuestion();
			obj[1]=info.getOptionA();
			obj[2]=info.getOptionB();
			obj[3]=info.getOptionC();
			obj[4]=info.getOptionD();
			obj[5]=info.getSubject();
			obj[6]=info.getAnswer();
			flag=controlDml(sql,obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteQuestionInfoById(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="DELETE FROM question_info WHERE QuestionId=?";
			Object[] obj=new Object[1];
			obj[0]=id;
			flag=controlDml(sql,obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void exitQuestion() {
		// TODO Auto-generated method stub
		System.exit(1);
	}

	public void callprocedure2(int a, int b) {
		boolean flag=false;
		try {
			String sql="CALL ups_test_01(?,?,?)";
			cstate= getCon().prepareCall(sql);
			//赋值
			cstate.setInt(1, a);
			cstate.setInt(2, b);
			flag=cstate.execute();//执行
			System.out.println("flag--------->"+flag);
			//获取值 
			int r=cstate.getInt(3);
			System.out.println("--------------------->r:"+r);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void callprocedure() {
		// TODO Auto-generated method stub
		
	}
	
	

}

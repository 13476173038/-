import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:JDBC_Dao
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:
 * Date:2018年3月28日下午3:13:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:13:05 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao{
	
	private static final Object QuestionId = null;
	ArrayList<QuestionInfo> list=new ArrayList<QuestionInfo>();
	QuestionInfo que=new QuestionInfo();
	int count = 0;
	//查询所有试题
	public  void getAll(){		
		try {
			String sql="SELECT * FROM QuestionInfo";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()) {				
				que.setQuestionId(rs.getInt(1));
				que.setQuestion(rs.getString(2));
				que.setOptionA(rs.getString(3));
				que.setOptionB(rs.getString(4));
				que.setOptionC(rs.getString(5));
				que.setOptionD(rs.getString(6));
				que.setSubject(rs.getInt(7));
				que.setAnswer(rs.getString(8));
				list.add(que);
				for (QuestionInfo que : list) {
					System.out.println(que.getQuestionId()+que.getQuestion()+que.getOptionA()
							+que.getOptionB()+que.getOptionC()+que.getOptionD()
							+que.getSubject()+que.getAnswer());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs,pst,con);
		}									
	}

	//按科目查询试题
	public void selectsubject() {

		try {
			String sql="SELECT * FROM QuestionInfo  where  subject=?";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()) {
				QuestionInfo que=new QuestionInfo();
				que.setQuestionId(rs.getInt(1));
				que.setQuestion(rs.getString(2));
				que.setOptionA(rs.getString(3));
				que.setOptionB(rs.getString(4));
				que.setOptionC(rs.getString(5));
				que.setOptionD(rs.getString(6));
				que.setSubject(rs.getInt(7));
				que.setAnswer(rs.getString(8));
				list.add(que);
				getAll();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs,pst,con);
		}		
	}
	
     //按题干模糊查询试题
	public List<QuestionInfo> select_t(String t) {
		try {
			String sql="SELECT * FROM QuestionInfo  where  question like '%"+t+"%'";
			pst=con.prepareStatement(sql);
		
			rs=pst.executeQuery();
			while (rs.next()) {
				QuestionInfo que=new QuestionInfo();
				que.setQuestionId(rs.getInt(1));
				que.setQuestion(rs.getString(2));
				que.setOptionA(rs.getString(3));
				que.setOptionB(rs.getString(4));
				que.setOptionC(rs.getString(5));
				que.setOptionD(rs.getString(6));
				que.setSubject(rs.getInt(7));
				que.setAnswer(rs.getString(8));
				list.add(que);
				for (QuestionInfo que1 : list) {
					System.out.println(que1.getQuestionId()+que1.getQuestion()+que1.getOptionA()
							+que1.getOptionB()+que1.getOptionC()+que1.getOptionD()
							+que1.getSubject()+que1.getAnswer());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs,pst,con);
		}
		return list;
		
	}
     //添加试题
	@Override
	public void insert() {
		
		//  Auto-generated method stub
		int flag=0;
		try {
			String sql="INSERT INTO "
+"QuestionInfo(QuestionId,Question,optionA,optionB,optionC,optionD,subject,answer) VALUES(?,?,?,?,?,?,?,?)";
			Object[] obj=new Object[7];
			QuestionInfo t = null;
			if(t instanceof QuestionInfo){
				QuestionInfo que=(QuestionInfo)t;
				obj[0]=que.getQuestionId();
				obj[1]=que.getQuestion();
				obj[2]=que.getOptionA();
				obj[3]=que.getOptionB();
				obj[4]=que.getOptionC();
				obj[5]=que.getOptionD();
				obj[6]=que.getSubject();
				obj[7]=que.getAnswer();
				getAll();
			}
			flag=controlDml(sql,obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
    //删除试题
	
	public boolean delete(int choose){  
        boolean flage = false;         
        if(choose <= 0 || choose > list.size()){  
            System.out.println("对不起，没有要删除的编号！请重新输入");  
        }else{  
            list.remove(choose - 1);  
            
			count++;  
            flage = true;  
            System.out.println("删除成功");  
        }  
        getAll(); 
        return false;  
    }  
	
    //按试题编号查询试题
	public void selectQuestionId() {				
		try {
			String sql="SELECT * FROM QuestionInfo  where  QuestionId=?";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()) {
				QuestionInfo que=new QuestionInfo();
				que.setQuestionId(rs.getInt(1));
				que.setQuestion(rs.getString(2));
				que.setOptionA(rs.getString(3));
				que.setOptionB(rs.getString(4));
				que.setOptionC(rs.getString(5));
				que.setOptionD(rs.getString(6));
				que.setSubject(rs.getInt(7));
				que.setAnswer(rs.getString(8));
				list.add(que);
				getAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(rs,pst,con);
		}
	}


	

	

	
	

	

	

}


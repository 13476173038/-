/**
 * Project Name:SIXwork
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:m03.d28.luojuan.dao.impl
 * Date:2018年3月28日下午7:18:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.luojuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import m03.d28.luojuan.dao.BaseDao;
import m03.d28.luojuan.dao.QuestionInfoDao;
import m03.d28.luojuan.eneity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午7:18:43 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllInfo() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info";
        try {
            ps = getcon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }
        return list;
    }

    @Override
    public int selectSub(Object t) {

        int flag = 0;
        try {
            String sql = "SELECT * FROM question_info WHERE SUBJECT=?";
            Object[] obj = new Object[1];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                obj[0] = ff.getSubject();
            }
            // obj[0] = subject;
            flag = contro(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int selectId(int t) {

        return 0;
    }

    @Override
    public String selectQues(String t) {

        return null;
    }

    @Override
    public int addSt(Object t) {
        int flag = 0;
        try {
            String sql = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,SUBJECT,answer) VALUES(?,?,?,?,?,?,?);";
            Object[] obj = new Object[7];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                // obj[0] = ff.getQuestionId();
                obj[0] = ff.getQuestion();
                obj[1] = ff.getOptionA();
                obj[2] = ff.getOptionB();
                obj[3] = ff.getOptionC();
                obj[4] = ff.getOptionD();
                obj[5] = ff.getSubject();
                obj[6] = ff.getAnswer();
            }
            flag = contro(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int deleteSt(int questionId) {

        int flag = 0;
        try {
            String sql = "DELETE FROM  question_info WHERE questionId=?";
            Object[] obj = new Object[1];
            obj[0] = questionId;
            flag = contro(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}

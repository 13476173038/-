/**
 * Project Name:SIXwork
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.luojuan.dao
 * Date:2018年3月28日下午7:17:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.luojuan.dao;

import java.util.List;

import m03.d28.luojuan.eneity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午7:17:30 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {

    // 查询所有试题
    List<QuestionInfo> getAllInfo();

    // 按科目查询
    int selectSub(Object t);

    // 按题干模糊查询
    String selectQues(String t);

    // 添加试题
    int addSt(T t);

    // 删除试题
    int deleteSt(int questionId);

    // 按编号查询
    // List<QuestionInfo> getAll();
    int selectId(int t);
}

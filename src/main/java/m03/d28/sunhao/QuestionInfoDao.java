/**
 * Project Name:SIXwork
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.sunhao
 * Date:2018年3月29日上午9:02:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.sunhao;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月29日 上午9:02:51 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */

public interface QuestionInfoDao<T> {
    // 获取所有
    void getAll();

    // 按科目查询试题
    void selectsubject();

    // 按题干模糊查询试题
    List<QuestionInfo> select_t(String t);

    // 添加试题
    void insert();

    // 删除试题
    boolean delete(int choose);

    // 按试题编号查询试题
    void selectQuestionId();

}

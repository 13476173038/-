/**
 * Project Name:Shopping
 * File Name:BizDao.java
 * Package Name:fc.dao
 * Date:2018年4月19日下午12:16:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.dao;

import java.util.List;

import fc.entity.Shangping;
import fc.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:16:02 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public interface BizDao {

    List<Shangping> getAllShanping();

    boolean validateUser(User user);

    Shangping getShangpingById(int id);
}

/**
 * Project Name:neiz
 * File Name:BizDao.java
 * Package Name:neiz.dao
 * Date:2018年4月3日下午4:01:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package neiz.dao;

import neiz.entity.UInfo;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午4:01:04 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public interface BizDao {
    boolean validateUser(UInfo user);
}

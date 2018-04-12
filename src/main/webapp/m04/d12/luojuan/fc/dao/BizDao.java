/**
 * Project Name:PinHong
 * File Name:BizDao.java
 * Package Name:fc.dao
 * Date:2018年4月12日下午7:17:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.dao;

import java.util.List;

import fc.entity.News;
import fc.entity.Product;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:17:53 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProduct();
}

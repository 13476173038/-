/**
 * Project Name:neiz
 * File Name:BizServiceImpl.java
 * Package Name:neiz.service.impl
 * Date:2018年4月3日下午3:18:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package neiz.service.impl;

import neiz.dao.BizDao;
import neiz.entity.UInfo;
import neiz.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:18:25 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    private BizDao bizdao;

    @Override
    public boolean validateUser(UInfo user) {
        return bizdao.validateUser(user);
    }
}

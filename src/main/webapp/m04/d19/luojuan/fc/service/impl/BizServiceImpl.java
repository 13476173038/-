/**
 * Project Name:Shopping
 * File Name:BizServiceImpl.java
 * Package Name:fc.service.impl
 * Date:2018年4月19日下午6:03:26
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.service.impl;

import java.util.List;

import fc.dao.BizDao;
import fc.entity.Shangping;
import fc.entity.User;
import fc.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午6:03:26 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {

    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public List<Shangping> getAllShanping() {

        return bizdao.getAllShanping();
    }

    @Override
    public boolean validateUser(User user) {

        return bizdao.validateUser(user);
    }

    @Override
    public Shangping getShangpingById(int id) {

        // Auto-generated method stub
        return bizdao.getShangpingById(id);
    }

}

/**
 * Project Name:PinHong
 * File Name:BizServiceImpl.java
 * Package Name:fc.servie.impl
 * Date:2018年4月12日下午7:32:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.servie.impl;

import java.util.List;

import fc.dao.BizDao;
import fc.entity.News;
import fc.entity.Page;
import fc.entity.Product;
import fc.entity.User;
import fc.servie.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:32:20 <br/>
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
    public List<News> getAllNews() {

        return bizdao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {

        return bizdao.getAllProduct();
    }

    @Override
    public boolean validateUser(User user) {

        return bizdao.validateUser(user);
    }

    @Override
    public List<User> getAllUser() {

        return bizdao.getAllUser();
    }

    @Override
    public String getUserRoleByName(String name, String pwd) {

        return bizdao.getUserRoleByName(name, pwd);
    }

    @Override
    public List<Product> getAllProductByPage(Page page) {

        return bizdao.getAllProductByPage(page);
    }

    @Override
    public int getProductNumber() {

        return bizdao.getProductNumber();
    }

}

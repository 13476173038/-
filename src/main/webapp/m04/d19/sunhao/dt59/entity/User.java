/**
 * Project Name:Shopping
 * File Name:User.java
 * Package Name:com.dt59.impl
 * Date:2018��4��19������2:31:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018��4��19�� ����2:31:11 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class User {
    private int uid;

    private String uname;

    private String upwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}

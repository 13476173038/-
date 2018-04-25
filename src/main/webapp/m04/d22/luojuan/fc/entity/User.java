/**
 * Project Name:Shopping
 * File Name:User.java
 * Package Name:fc.entity
 * Date:2018年4月19日下午7:40:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午7:40:12 <br/>
 * 
 * @author luojuan
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

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

}

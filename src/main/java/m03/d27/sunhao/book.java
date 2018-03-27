/**
 * Project Name:lesson
 * File Name:bool.java
 * Package Name:JDBC
 * Date:2018年3月26日下午4:30:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package JDBC;

/**
 * Description: <br/>
 * Date: 2018年3月26日 下午4:30:50 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class book {
    private int bid;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubcomp() {
        return pubcomp;
    }

    public void setPubcomp(String pubcomp) {
        this.pubcomp = pubcomp;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getBcount() {
        return bcount;
    }

    public void setBcount(int bcount) {
        this.bcount = bcount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String bname;

    private String author;

    private String pubcomp;

    private String pubDate;

    private int bcount;

    private int price;

}

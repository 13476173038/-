/**
 * Project Name:PinHong
 * File Name:Page.java
 * Package Name:fc.entity
 * Date:2018年4月16日下午9:23:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package fc.entity;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午9:23:58 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class Page {
    private int currentpage;

    private int pagesize = 3;

    private int sumsize;

    private int lastpage;

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage <= 0) {
            this.currentpage = 1;
        } else {
            this.currentpage = currentpage;
        }
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSumsize() {
        return sumsize;
    }

    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

}

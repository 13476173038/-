/**
 * Project Name:Demo_jsp_1
 * File Name:page.java
 * Package Name:com.dt59.entity
 * Date:2018年4月11日下午2:56:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年4月11日 下午2:56:35 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class Page {
	private int totalPageCount;//总页数
	private int currentpage;//当前页
	private int pagesize=3;//每页的条数
	private int sumsize;//总条数
	private int lastpage;//尾页
	private List<NewsInfo> newsList;
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
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
		if (sumsize>0) {
			this.sumsize = sumsize;
			//计算总的页数
			totalPageCount=this.sumsize%pagesize==0?
		(this.sumsize/pagesize):(this.sumsize/pagesize+1);		
		}
		
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {		
		this.totalPageCount = totalPageCount;
	}
	public List<NewsInfo> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<NewsInfo> newsList) {
		this.newsList = newsList;
	}
	
	

}


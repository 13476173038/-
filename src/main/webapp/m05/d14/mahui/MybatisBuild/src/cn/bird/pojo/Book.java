package cn.bird.pojo;

import java.sql.Date;

public class Book {
	private int bid;
	private String bname;
	private Date bpubTime;
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
	public Date getBpubTime() {
		return bpubTime;
	}
	public void setBpubTime(Date bpubTime) {
		this.bpubTime = bpubTime;
	}
	
}

package com.dt59.entity;

import java.sql.Date;

public class CommentInfo {
	private String comment;
	private Date fbtime;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getFbtime() {
		return fbtime;
	}
	public void setFbtime(Date fbtime) {
		this.fbtime = fbtime;
	}
	
}

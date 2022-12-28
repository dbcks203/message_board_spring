package com.myspring.pro27.entity;

import lombok.Data;

@Data
public class BoardVO {
	private String seq;
	private String parentNo;
	private String userId;
	private String subject;
	private String content;
	private String regDate;
	private String tag;
	private String readCount;
	private String like_count;
	private String dis_like_count;

}

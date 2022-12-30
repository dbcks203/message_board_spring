package com.myspring.pro27.entity;

import lombok.Data;

@Data
public class BoardVO {
	private String number;
	private String parentno;
	private String title;
	private String content;
	private String writeid;
	private String writedate;
	private String viewcount;
	
}

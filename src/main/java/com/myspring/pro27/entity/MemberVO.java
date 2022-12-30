package com.myspring.pro27.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String uid;
	private String pwd;
	private String name;
	private String sex;
	private String address;
	private String phone;
	private String email;
	private Date createDate;
}

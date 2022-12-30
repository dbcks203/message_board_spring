package com.myspring.pro27.entity;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardFile implements Serializable {
	private static final long serialVersionUID = -6675626554487766989L;

	private int f_id;
	private long number;
	private String org_name;
	private String real_name ; ;
	private String content_type;
	private BigInteger   length;
	private String thumbnail; 
   
}
   

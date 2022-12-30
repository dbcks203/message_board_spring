package com.myspring.pro27.mappers;

import java.util.List;

import com.myspring.pro27.entity.MemberVO;

public interface MemberDAO {
	MemberVO selectView(String uid);

	List<MemberVO> listMembers();
}

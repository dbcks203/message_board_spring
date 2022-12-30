package com.myspring.pro27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.pro27.entity.MemberVO;
import com.myspring.pro27.mappers.MemberDAO;

@Service
public class MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	public MemberVO login(String uid, String pwd) {
		MemberVO memberVO = memberDAO.selectView(uid);
		if (memberVO != null && memberVO.getPwd().equals(pwd)) {
			return memberVO;
		}
		
		return null;
	}

	public List<MemberVO> listMembers() {
		return memberDAO.listMembers();
	}

	public Object view(String uid) {
		return memberDAO.selectView(uid);
	}
}

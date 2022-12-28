package com.myspring.pro27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.pro27.entity.BoardVO;
import com.myspring.pro27.mappers.BoardDAO;

@Service("boardService")
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardVO> boardList() {
		return boardDAO.boardList();
	}
}

package com.myspring.pro27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.pro27.entity.BoardFile;
import com.myspring.pro27.mappers.BoardFileDAO;

@Service
public class FileUploadService {
	
	@Autowired
	BoardFileDAO boardFileDAO;
	
	public void FileSave(List<BoardFile> list) {
		for(BoardFile boardFile : list) {
			boardFileDAO.insert(boardFile);
		}
	}

	public BoardFile getBoardFile(String f_id) {
		return boardFileDAO.getBoardFile(f_id);
	}
}

package com.myspring.pro27.mappers;

import java.util.List;

import com.myspring.pro27.entity.BoardFile;

public interface BoardFileDAO {
	int insert(BoardFile boardFile);

	BoardFile getBoardFile(String f_id);
}

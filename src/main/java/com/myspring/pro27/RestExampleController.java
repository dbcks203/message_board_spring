package com.myspring.pro27;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.pro27.entity.MemberVO;
import com.myspring.pro27.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@RestController
@
public class RestExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/member/{uid}")
	public List<MemberVO> memberView(@PathVariable("uid") String uid) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for(int i=0;i<10;i++) {
		MemberVO member = MemberVO.builder().uid("user"+i).pwd("1234").sex("M").address("혜화역").phone("010-2020").name("hong").build();
		list.add(member);
		}
	return list;
	
	}
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/listArticles.do")
	public String boardList(Locale locale, Model model) {
		
		model.addAttribute("boardList", boardService.boardList());
		
		return "/board/boardList";
	}
}

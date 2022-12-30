package com.myspring.pro27;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myspring.pro27.entity.MemberVO;
import com.myspring.pro27.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/member/loginForm.do")
	public String loginForm(Locale locale, Model model) {
		return "/member/loginForm";
	}
	
	@Autowired 
	MemberService memberService;
	
	@RequestMapping(value = "/member/login.do")
	public String login(@RequestParam(value="uid", required = true) String uid,
			@RequestParam(value="pwd", required = true) String pwd, Model model,
			HttpSession session ) {
		
		MemberVO member = memberService.login(uid, pwd);
		if (member != null) {
			session.setAttribute("isLogOn", true);
			session.setAttribute("member", member);
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/member/logout.do")
	public String logout(HttpSession session ) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/member/listMembers.do")
	public String listMembers(Model model) {
		
		model.addAttribute("list", memberService.listMembers());
		
		return "/member/listMembers";
	}
	
	@RequestMapping(value = "/member/view.do")
	public String view(@RequestParam(value="uid", required = true) String uid, Model model) {
		
		logger.debug("view() before ======================== ");
		model.addAttribute("member", memberService.view(uid));
		logger.debug("view() after ======================== ");
		
		return "/member/view";
	}
	
}

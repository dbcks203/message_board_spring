package com.myspring.pro27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.pro27.service.MailService;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableAsync
public class MailController {
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	MailService mailService;

	@RequestMapping(value = "/sensMail.do", method = RequestMethod.GET)
	public void sensMail(HttpServletRequest request, HttpServletResponse response) 
		throws Exception  {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/mailTemplate.html"), "utf-8"));

		StringBuilder str = new StringBuilder();
		reader.lines().forEach(lineText -> {
			str.append(lineText);
		});
		String htmlStr = str.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		htmlStr = htmlStr.replace("${USERNAME}", "홍길동");
		htmlStr = htmlStr.replace("${DATETIME}", sdf.format(Calendar.getInstance().getTime()));
		 
		mailService.sendMail("masungil2@daum.net", "테스트 메일", htmlStr);
		
		PrintWriter out = response.getWriter();
		out.println("메일을 보냈습니다~~~");
		
	}
	
}

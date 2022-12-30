package com.myspring.pro27;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myspring.pro27.entity.BoardFile;
import com.myspring.pro27.service.FileUploadService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileDownloadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(value = "/fileDownload.do", method = RequestMethod.GET)
	public void fileDownload(@RequestParam("f_id") String f_id, HttpServletResponse response) 
		throws Exception  {
		BoardFile boardFile = fileUploadService.getBoardFile(f_id);
		if (boardFile != null) {
			response.setHeader("Cache-Control", "no-cache");
			response.setContentLength(boardFile.getLength().intValue());
			response.addHeader("Content-disposition", "attachment; fileName=" + boardFile.getOrg_name());
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("c:\\upload\\" + boardFile.getReal_name()));
			
			byte [] data = new byte[4096];
			int count = 0;
			while(true) {
				count = in.read(data);
				if (count <= 0) break;
				out.write(data);
			}
			out.close();
			in.close();
		}
		
	}
	
	@RequestMapping(value = "/thumbnail.do", method = RequestMethod.GET)
	public void thumbnail(@RequestParam("f_id") String f_id, HttpServletResponse response) 
		throws Exception  {
		BoardFile boardFile = fileUploadService.getBoardFile(f_id);
		if (boardFile != null) {
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Content-disposition", "attachment; fileName=" + boardFile.getThumbnail());
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("c:\\upload\\" + boardFile.getThumbnail()));
			
			byte [] data = new byte[4096];
			int count = 0;
			while(true) {
				count = in.read(data);
				if (count <= 0) break;
				out.write(data);
			}
			out.close();
			in.close();
		}
		
	}
}

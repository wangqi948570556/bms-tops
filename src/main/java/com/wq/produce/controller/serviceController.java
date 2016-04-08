package com.wq.produce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class serviceController {
	//调用日志文件
	private static Log logger = LogFactory.getLog(serviceController.class);
	
	@RequestMapping("/test")
	@ResponseBody
	public void a(
            @RequestParam(value = "scope", required = false) String scope,
            HttpServletRequest request, HttpServletResponse response){
		try {
			System.out.println("hehehhehehh");
			int a = 3/0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Find projectCategories failed.", e);
		}
	}
}

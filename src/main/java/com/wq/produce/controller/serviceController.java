package com.wq.produce.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class serviceController {
	//调用日志文件
	private static Log logger = LogFactory.getLog(serviceController.class);
	
	@RequestMapping("/test")
	@ResponseBody
	public ModelAndView a(
            @RequestParam(value = "scope", required = false) String scope,
            HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("hehehhehehh");
			model.put("name", "大家好，我是王奇");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Find projectCategories failed.", e);
		}
		return new ModelAndView("imagRotation",model);
	}
}

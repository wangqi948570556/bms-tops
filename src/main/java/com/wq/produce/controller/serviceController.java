package com.wq.produce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class serviceController {
	@RequestMapping("/test")
	public void a(){
		System.out.println("hehehhehehh");
	}
}

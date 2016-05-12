package com.wq.produce.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    //调用日志文件
    private static Log logger = LogFactory.getLog(ServiceController.class);
    
    @RequestMapping(value = "test" , method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getInfoJsp(
            @RequestParam(value = "scope", required = false) String scope,
            HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        try {
            System.out.println("hehehhehehh");
            List<Map<String,Object>> modes = new ArrayList<Map<String,Object>>();
            for(int i=0;i<3;i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("obj", "我不知奥"+i);
                modes.add(map);
            }
            mv.addObject("modes",modes);
            mv.addObject("name","我啊啊");
            mv.setViewName("imagRotation");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find projectCategories failed.", e);
        }
        return mv;
    }
    
    @RequestMapping(value = "getInfo" , method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getInfoString(
            @RequestParam(value = "scope", required = false) String scope,
            Model model,
            HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        try {
            scope = new String(scope.getBytes("ISO-8859-1"), "UTF-8"); 
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find projectCategories failed.", e);
        }
        return mv;
    }
}

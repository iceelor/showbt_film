package com.showbt.crawler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class TempManagerController {
	
	 @RequestMapping("/test")
	    public ModelAndView index(){
	        ModelAndView mav = new ModelAndView("test");
	        mav.addObject("title", "网站标题");
	        //在这里可以控制不生成静态htm
	        mav.addObject("CREATE_HTML", false);
	        return mav;
	    }
	     
	    @RequestMapping("/abc/index")
	    public ModelAndView abcindex(){
	        ModelAndView mav = new ModelAndView("test");
	        //默认生成htm文件
	        mav.addObject("title", "网站标题");
	        return mav;
	    }
}

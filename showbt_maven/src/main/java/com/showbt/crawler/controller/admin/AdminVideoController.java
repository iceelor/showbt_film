package com.showbt.crawler.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showbt.crawler.service.VideoService;

@Controller
@RequestMapping(value="/admin")
public class AdminVideoController {
	private @Autowired VideoService videoService;
	
	@RequestMapping(value="/collectVideo")
	public String collectVideo(HttpServletRequest request, HttpServletResponse response){
		return "admin/collectVideo";
	}
	
	@RequestMapping(value="/youkuCollect")
	@ResponseBody
	public String youkuCollect(HttpServletRequest request, HttpServletResponse response){
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int min = 1;
		int max =50;
		if(NumberUtils.isDigits(start) && NumberUtils.isDigits(end)){
			min = Integer.parseInt(start);
			max = Integer.parseInt(end);
		}
		System.out.println(min+"ddddd::"+max);
		String url = "http://fun.youku.com/xiaodian/index/_page83102_2.html";
		for(;min<=max; min++){
			if(min>0){
				url = "http://fun.youku.com/xiaodian/index/_page83102_"+min+".html";
				try {
					videoService.collectVideo(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
        return "finished";
	}
}

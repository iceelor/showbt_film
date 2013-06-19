package com.showbt.crawler.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("film_admin_indexController")
@RequestMapping(value="/admin")
public class AdminIndexController {
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "admin/main";
	}
	@RequestMapping(value="/left")
	public String left(HttpServletRequest request, HttpServletResponse response){
		return "admin/left";
	}
	@RequestMapping(value="/top")
	public String top(HttpServletRequest request, HttpServletResponse response){
		return "admin/top";
	}
	@RequestMapping(value="/middel")
	public String middel(HttpServletRequest request, HttpServletResponse response){
		return "admin/middel";
	}
	@RequestMapping(value="/center")
	public String center(HttpServletRequest request, HttpServletResponse response){
		return "admin/center";
	}
	@RequestMapping(value="/down")
	public String down(HttpServletRequest request, HttpServletResponse response){
		return "admin/down";
	}
}

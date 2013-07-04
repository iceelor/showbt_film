package com.showbt.crawler.controller.admin;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.showbt.crawler.common.TemplateManager;

@Controller
@RequestMapping(value = "/admin")
public class TempManagerController {

	@RequestMapping("/test")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/test");
		mav.addObject("user", "网站标题");
		String templatePath = "admin/test.ftl";
		String targetHtmlPath = "admin/test.html";
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("user", "oh my god!");
		TemplateManager.getInstance().createHTML(model, templatePath,targetHtmlPath, request);
		return mav;
	}

	@RequestMapping("/abc/index")
	public ModelAndView abcindex() {
		ModelAndView mav = new ModelAndView("test");
		// 默认生成htm文件
		mav.addObject("title", "网站标题");
		return mav;
	}
}

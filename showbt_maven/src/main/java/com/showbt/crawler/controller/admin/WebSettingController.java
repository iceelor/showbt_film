package com.showbt.crawler.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.showbt.crawler.bean.WebSetting;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.common.controller.BaseController;

@Controller("webSetting_Controller")
@RequestMapping(value="/admin")
public class WebSettingController extends BaseController{
	
	@RequestMapping(value="/webSetting")
	public String ad(HttpServletRequest request, HttpServletResponse response){
		Map<String,WebSetting> wsList = Cache.getInstance().getWebSettingCache(webSettingService);
		request.setAttribute("wsList", wsList);
		return "admin/wsList";
	}
	
	@RequestMapping(value="/addWs")
	public String addWs(HttpServletRequest request, HttpServletResponse response){
		return "admin/addWs";
	}
	
	@RequestMapping(value="/addWsDo")
	public String addWsDo(HttpServletRequest request, HttpServletResponse response){
		String sKey = request.getParameter("sKey");
		String sValue = request.getParameter("sValue");
		WebSetting ws = new WebSetting();
		ws.setsKey(sKey);
		ws.setsValue(sValue);
		webSettingService.editSave(ws);
		Cache.setWebSettingCache(null);
		return "redirect:webSetting.action";
	}
	
	@RequestMapping(value="/updateWs")
	public String updateWs(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		long id = 0;
		if(NumberUtils.isDigits(sid)){
			id = Long.parseLong(sid);
		}else{
			return "redirect:webSetting.action";
		}
		WebSetting ws = webSettingService.getWebSetting(id);
		request.setAttribute("ws", ws);
		return "admin/updateWs";
	}
	
	@RequestMapping(value="/updateWsDo")
	public String updateWsDo(HttpServletRequest request, HttpServletResponse response){
		
		String sid = request.getParameter("id");
		long id = 0;
		if(NumberUtils.isDigits(sid)){
			id = Long.parseLong(sid);
		}else{
			return "redirect:webSetting.action";
		}
		String sKey = request.getParameter("sKey");
		String sValue = request.getParameter("sValue");
		WebSetting ws = webSettingService.getWebSetting(id);
		ws.setsKey(sKey);
		ws.setsValue(sValue);
		webSettingService.edit(ws);
		Cache.setWebSettingCache(null);
		return "redirect:webSetting.action";
	}
}

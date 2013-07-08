package com.showbt.crawler.common.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.showbt.crawler.bean.Adverting;
import com.showbt.crawler.bean.WebSetting;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.service.AdvertingService;
import com.showbt.crawler.service.KeyWordService;
import com.showbt.crawler.service.WebSettingService;

@Controller
public class BaseController {
	protected @Autowired AdvertingService advertingService;
	protected @Autowired WebSettingService webSettingService;
	protected @Autowired KeyWordService keyWordService;
	
	
	protected String getWebSetting(String key){
		Map<String,WebSetting> wsList = Cache.getInstance().getWebSettingCache(webSettingService);
		if(wsList==null || wsList.size()<1) return "";
		return wsList.get(key).getsValue();
	}
	
	protected String getDefaultTemptalePath(HttpServletRequest request){
		this.initation(request);
		request.setAttribute("staticServePath", request.getContextPath());
		return "/"+getWebSetting("websetting_template_default_path");
	}
	
	protected void initation(HttpServletRequest request){
		Map<String,WebSetting> wsList = Cache.getInstance().getWebSettingCache(webSettingService);
		for(Entry<String, WebSetting> e : wsList.entrySet()){
			request.setAttribute(e.getKey().trim(), e.getValue().getsValue());
		}	
		Map<String, Adverting> adList = Cache.getInstance().getAdvertingCache(advertingService);
		for(Entry<String, Adverting> e : adList.entrySet()){
			request.setAttribute(e.getKey().trim(), e.getValue().getAdCode());
		}	
	}
	
	protected Map<String, Object> initTemplateData(HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("staticServePath", request.getContextPath());
		Map<String,WebSetting> wsList = Cache.getInstance().getWebSettingCache(webSettingService);
		for(Entry<String, WebSetting> e : wsList.entrySet()){
			model.put(e.getKey().trim(), e.getValue().getsValue());
		}	
		Map<String, Adverting> adList = Cache.getInstance().getAdvertingCache(advertingService);
		for(Entry<String, Adverting> e : adList.entrySet()){
			model.put(e.getKey().trim(), e.getValue().getAdCode());
		}	
		return model;
	}
}

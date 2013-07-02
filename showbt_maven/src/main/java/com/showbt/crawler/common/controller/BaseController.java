package com.showbt.crawler.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
	protected String getDefaultTemptalePath(){
		return "/"+getWebSetting("websetting_template_default_path");
	}
}

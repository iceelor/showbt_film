package com.showbt.crawler.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showbt.crawler.service.AdvertingService;
import com.showbt.crawler.service.CategoryService;
import com.showbt.crawler.service.WebSettingService;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

@Component
public class FreemarkerStatic implements TemplateMethodModel{
	
	private @Autowired WebSettingService webSettingService;
	private @Autowired AdvertingService advertingService;
	private @Autowired CategoryService categoryService;
	
	@Override
	public Object exec(List arg0) throws TemplateModelException {
		String key = arg0.get(0).toString();
		String [] ks = key.split("@");
		Object result = null;
		if(ks[0].toUpperCase().equals("WebSetting".toUpperCase())){
			result = Cache.getInstance().getWebSettingCache(webSettingService).get(ks[1]);
		}else if(ks[0].toUpperCase().equals("Adverting".toUpperCase())){
			result = Cache.getInstance().getAdvertingCache(advertingService).get(ks[1]);
		}else if(ks[0].toUpperCase().equals("Category".toUpperCase())){
			result = Cache.getInstance().getCategoryCache(categoryService).get(ks[1]);
		}
		return result;
	}
}

package com.showbt.crawler.service;
import java.util.List;

import com.showbt.crawler.bean.WebSetting;
import com.showbt.crawler.common.service.BaseService;

public interface WebSettingService extends BaseService<WebSetting> {
	
	public List<WebSetting> getWebSettingAll();
	
	public WebSetting getWebSetting(long id);
	
}
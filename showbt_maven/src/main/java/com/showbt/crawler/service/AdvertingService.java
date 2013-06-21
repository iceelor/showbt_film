package com.showbt.crawler.service;
import java.util.List;

import com.showbt.crawler.bean.Adverting;
import com.showbt.crawler.common.service.BaseService;

public interface AdvertingService extends BaseService<Adverting> {
	
	
	public List<Adverting> getAdvertingAll();
	
	public Adverting getAdverting(long id);
	
}
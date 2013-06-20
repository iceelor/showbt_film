package com.showbt.crawler.service;
import java.util.List;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.common.service.BaseService;

public interface CategoryService extends BaseService<Category> {
	
	
	public List<Category> getCategoryAll();
	
	public Category getCategory(long id);
	
}
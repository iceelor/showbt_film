package com.showbt.crawler.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.service.CategoryService;

@Component
public class Cache {
	private static Cache cache = null;
	
	private static Map<String, Category> categoryCache = null;
	private Cache(){}
	
	public static Cache getInstance(){
		if(cache == null){
			cache = new Cache();
		}
		return cache;
	}

	public Map<String, Category> getCategoryCache(CategoryService categoryService) {
		if(categoryCache == null){
			List<Category> cList = categoryService.getCategoryAll();
			categoryCache = new LinkedHashMap<String, Category>();
			//暂时只支持两级
			for(Category c: cList){
				if(c.getParentId() == 0){
					if(categoryCache.get(c.getId()+"")==null){
						categoryCache.put(c.getId()+"", c);
					}
				}else{
					Category temp = categoryCache.get(c.getParentId()+"");
					if(temp != null){
						List<Category> clist = temp.getChild();
						if(clist == null){
							clist = new ArrayList<Category>();
						}
						clist.add(c);
						temp.setChild(clist);
						categoryCache.put(c.getParentId()+"", temp);
					}
				}
			}
		}
		return categoryCache;
	}

}

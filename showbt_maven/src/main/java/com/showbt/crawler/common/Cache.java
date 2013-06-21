package com.showbt.crawler.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.showbt.crawler.bean.Adverting;
import com.showbt.crawler.bean.Category;
import com.showbt.crawler.service.AdvertingService;
import com.showbt.crawler.service.CategoryService;

@Component
public class Cache {
	private static Cache cache = null;
	
	private static Map<String, Category> categoryCache = null;
	
	private static Map<String, Adverting> advertingCache = null;
	public static void setCategoryCache(Map<String, Category> categoryCache) {
		Cache.categoryCache = categoryCache;
	}

	public static void setAdvertingCache(Map<String, Adverting> advertingCache) {
		Cache.advertingCache = advertingCache;
	}

	private Cache(){}
	
	public static Cache getInstance(){
		if(cache == null){
			cache = new Cache();
		}
		return cache;
	}

	/**
	 * 分类缓存
	 * @param categoryService
	 * @return
	 */
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
	
	/**
	 * 广告缓存
	 * @param adbertingService
	 * @return
	 */
	public Map<String, Adverting> getAdvertingCache(AdvertingService advertingService) {
		if(advertingCache == null){
			advertingCache = new LinkedHashMap<String, Adverting>();
			List<Adverting> dl = advertingService.getAdvertingAll();
			for(Adverting ad: dl){
				advertingCache.put(ad.getAdKey(), ad);
			}
		}
		return advertingCache;
	}
}

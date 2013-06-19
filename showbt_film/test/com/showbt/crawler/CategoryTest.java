package com.showbt.crawler;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.service.CategoryService;

public class CategoryTest {
	private ApplicationContext context;

	@Before
	public void before() {
		context =  new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
	}
	
	@Test
	public void testCategory(){
		CategoryService dytt8Service = (CategoryService) context.getBean("categoryService");
		Map<String, Category> clst = Cache.getInstance().getCategoryCache(dytt8Service);
		for(Entry<String, Category> e: clst.entrySet()){
			Category c = e.getValue();
			System.out.println(e.getKey()+"  "+c.getCategory());
			if(c.getParentId()==0){
				List<Category> cl = c.getChild();
				if(cl != null){
					for(Category cc : cl){
						System.out.println("          "+cc.getId()+"  "+cc.getCategory());
					}
				}
			}
			
		}
	}
	
}

package com.showbt.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.CategoryDAO;
import com.showbt.crawler.service.CategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	private @Autowired CategoryDAO<Category> categoryDao;
	
	@Override
	public List<Category> getCategoryAll() {
		String hql = "from Category c ";
		List<Category> dList = categoryDao.queryAll(hql);
		return dList;
	}

	@Override
	public Category getCategory(long id) {
		String hql = " from Category c where c.id="+id;
		List<Category> dList = categoryDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}


}

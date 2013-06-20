package com.showbt.crawler.dao.impl;

import org.springframework.stereotype.Repository;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.common.dao.impl.BaseDao;
import com.showbt.crawler.dao.CategoryDAO;

@Repository
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDAO<Category>{

}

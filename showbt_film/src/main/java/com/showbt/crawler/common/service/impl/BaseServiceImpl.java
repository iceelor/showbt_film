package com.showbt.crawler.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.common.dao.IBaseDao;
import com.showbt.crawler.common.exception.DaoException;
import com.showbt.crawler.common.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private IBaseDao<T> baseDao;
	
	@Override
	public void delete(T oto) throws DaoException {
		baseDao.delete(oto);
	}

	@Override
	public void edit(T oto) throws DaoException {
		baseDao.edit(oto);
	}

	@Override
	public void editSave(T oto) throws DaoException {
		baseDao.editSave(oto);
	}

	@Override
	public void editUpdate(T oto) throws DaoException {
		baseDao.editUpdate(oto);
	}

	@Override
	public List<T> queryAll(String hql) throws DaoException {
		return baseDao.queryAll(hql);
	}

	@Override
	public long count(String hql,Map<String, Object> value) throws DaoException {
		return baseDao.count(hql,value);
	}

	
}

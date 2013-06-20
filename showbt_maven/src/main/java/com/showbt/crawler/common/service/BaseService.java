package com.showbt.crawler.common.service;

import java.util.List;
import java.util.Map;

import com.showbt.crawler.common.exception.DaoException;

public interface BaseService<T> {

	/**
	 * 保存实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editSave(T oTO) throws DaoException;
	
	/**
	 * 修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editUpdate(T oTO) throws DaoException;
	
	/**
	 * 保存或修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void edit(T oTO) throws DaoException;

	/**
	 * 删除实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void delete(T oTO) throws DaoException;
	
	public List<T> queryAll(String hql) throws DaoException;
	
	public long count(String hql,Map<String, Object> value) throws DaoException; 
}

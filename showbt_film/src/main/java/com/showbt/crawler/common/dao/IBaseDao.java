package com.showbt.crawler.common.dao;

import java.util.List;
import java.util.Map;

import com.showbt.crawler.common.exception.DaoException;


/**
 * dao基类接口
 * @date 2011/04/07
 */
public interface IBaseDao<T> {
	
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
	
	public List<T> queryAll(String hql, Map<String ,Object> value) throws DaoException;
	
	public List<T> query(String hql, int page, int pageSize) throws DaoException;
	
	public List<T> query(String hql,Map<String ,Object> value, int page, int pageSize) throws DaoException;

	public long count(String hql,Map<String, Object> value) throws DaoException; 
	
}

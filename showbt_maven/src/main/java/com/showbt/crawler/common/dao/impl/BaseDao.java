package com.showbt.crawler.common.dao.impl;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.showbt.crawler.common.dao.IBaseDao;
import com.showbt.crawler.common.exception.DaoException;



/**
 * DAO基类
 * @param <T>
 * @date 2011/04/07
 */
@Repository
public class BaseDao<T> implements IBaseDao<T>{
	
    @Autowired
	private SessionFactory sessionFactory;

	/**
	 * 保存实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editSave(T oTO) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(oTO);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editUpdate(T oTO) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 保存或修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void edit(T oTO) throws DaoException {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 删除实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void delete(T oTO) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String hql, int page, int pageSize) throws DaoException {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setFirstResult((page-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String hql, Map<String ,Object> value, int page, int pageSize) throws DaoException {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q = setParams(q,value);
		q.setFirstResult((page-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll(String hql) throws DaoException {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll(String hql, Map<String ,Object> value) throws DaoException {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q = setParams(q,value);
		return q.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long count(String hql,Map<String, Object> value) throws DaoException {
		Query q = sessionFactory.getCurrentSession().createQuery("select count(*) "+hql);
		q = this.setParams(q, value);
		List<Long> res = q.list();
		return res.get(0);
	}

	private Query setParams(Query q, Map<String, Object> value){
		if(value==null)return q;
		for(Entry<String, Object> e: value.entrySet()){
			if(e.getValue() instanceof String){
				q.setString(e.getKey(), e.getValue().toString());
			}else if(e.getValue() instanceof Integer){
				q.setInteger(e.getKey(), Integer.parseInt(e.getValue().toString()));
			}else if(e.getValue() instanceof Long){
				q.setLong(e.getKey(), Long.parseLong(e.getValue().toString()));
			}else if(e.getValue() instanceof Double){
				q.setDouble(e.getKey(), Double.parseDouble(e.getValue().toString()));
			}
		}
		return q;
	}
}

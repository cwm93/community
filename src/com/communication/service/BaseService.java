package com.communication.service;

import java.io.Serializable;
import java.util.List;

import com.communication.dao.BaseDao;
import com.communication.util.Order;
import com.communication.util.Pager;
import com.communication.util.Property;

/**
 * 业务管理基类
 * 
 * @param <T>
 */

public class BaseService<T extends Serializable> {

	private BaseDao<T> dao;

	public void save(T entity) {
		dao.save(entity);
	}

	public void update(Object entity) {
		dao.update(entity);
	}

	public void delete(Object entity) {
		dao.delete(entity);
	}

	public void deleteById(Serializable id) {
		dao.delete(find(id));
	}

	public T find(Serializable id) {
		T entity = (T) dao.find(id);
		return entity;
	}

	public List<T> findAll() {
		return dao.findAll(Order.asc("id"));
	}
	
	public List<T> findAll(String order) {
		return dao.findAll(Order.asc(order));
	}

	public List<T> findByPager(Pager pager) {
		return getDao().findByPager(pager, Order.asc("id"));
	}

	public List<T> findByPager(Pager pager, Property... propertys) {
		return getDao().findByPager(pager, Order.asc("id"), propertys);
	}

	public List<T> findByPager(Pager pager, Order order, Property... propertys) {
		return getDao().findByPager(pager, order, propertys);
	}

	public List<T> findByPager(Pager pager, Order[] orders, Property... propertys) {
		return getDao().findByPager(pager, orders, propertys);
	}
	public List<T> executeQuery(String hql, Object... values) {
		return getDao().executeQuery(null, hql, values);
	}
	
	public long executeCount(String hql, Object... values) {
		return  getDao().executeCount(hql, values);
	}

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
}

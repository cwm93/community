package com.communication.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.communication.util.Order;
import com.communication.util.Property;
import com.communication.util.Pager;

/**
 * 数据库操作基类
 * 
 * @param <T>
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseDao<T extends Serializable> {

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(Object entity) {
		getSession().merge(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	public T find(Serializable id) {
		T entity = (T) getSession().get(clazz, id);
		return entity;
	}

	public List<T> findAll(Order order, Property... propertys) {
		return findByPager(null, new Order[] { order }, propertys);
	}

	public List<T> findAll(Order[] orders, Property... propertys) {
		return findByPager(null, orders, propertys);
	}

	public List<T> findByPager(Pager pager, Order order, Property... propertys) {
		return findByPager(pager, new Order[] { order }, propertys);
	}

	public List<T> findByPagers(Pager pager, int lastnum, Order order,
			Property... propertys) {
		return findByPagers(pager, lastnum, new Order[] { order }, propertys);
	}

	public List<T> findByPager(Pager pager, Order[] orders,
			Property... propertys) {
		Criteria criteria = getSession().createCriteria(clazz);
		// 查询条件
		for (Property property : propertys) {
			if (property != null)
				criteria.add(property.getCriterion());
		}
		// 分页
		if (pager != null) {
			criteria.setProjection(Projections.rowCount());
			Number  count = (Number) criteria.uniqueResult();

			if (count == null)
				return new ArrayList();
			// pager.setTotalSize(count);
			criteria.setFirstResult((pager.getCurrentPage() - 1)
					* pager.getPageSize());
			criteria.setMaxResults(pager.getPageSize());
			criteria.setProjection(null);
		}
		// 排序
		if (orders != null && orders.length > 0) {
			for (Order order : orders) {
				if (order != null)
					criteria.addOrder(order.getHibernateOrder());
			}
		}
		return criteria.list();
	}

	public List<T> findByPagers(Pager pager, int lastnum, Order[] orders,
			Property... propertys) {
		Criteria criteria = getSession().createCriteria(clazz);
		// 查询条件
		for (Property property : propertys) {
			if (property != null)
				criteria.add(property.getCriterion());
		}
		// 分页
		if (pager != null) {
			criteria.setProjection(Projections.rowCount());
			Integer count = (Integer) criteria.uniqueResult();

			if (count == null)
				return new ArrayList();
			// pager.setTotalSize(count);
			if (lastnum > pager.getPageSize() * (pager.getCurrentPage() - 1)) {
				criteria.setFirstResult(0);
				int lastSite = lastnum % pager.getPageSize();
				criteria.setMaxResults(pager.getPageSize() - lastSite);

			} else {
				int startPage = pager.getCurrentPage() - lastnum
						/ pager.getPageSize();
				int lastSite = lastnum % pager.getPageSize();
				criteria.setFirstResult((startPage - 1) * pager.getPageSize()
						- lastSite);
				criteria.setMaxResults(pager.getPageSize());
			}

			criteria.setProjection(null);
		}
		// 排序
		if (orders != null && orders.length > 0) {
			for (Order order : orders) {
				if (order != null)
					criteria.addOrder(order.getHibernateOrder());
			}
		}
		return criteria.list();
	}

	public Long countByProperty(String propertyName, Property... propertys) {
		Criteria criteria = getSession().createCriteria(clazz);
		// 查询条件
		for (Property property : propertys) {
			if (property != null)
				criteria.add(property.getCriterion());
		}
		criteria.setProjection(Projections.count(propertyName));
		return (Long) criteria.uniqueResult();
	}
	
	public int sumByProperty(String propertyName, Property... propertys) {
		Criteria criteria = getSession().createCriteria(clazz);
		// 查询条件
		for (Property property : propertys) {
			if (property != null)
				criteria.add(property.getCriterion());
		}
		criteria.setProjection(Projections.sum(propertyName));
		int sum = (Long) criteria.uniqueResult()==null ? 0:((Long) criteria.uniqueResult()).intValue();
		return sum;
	}
	
	public List<T> executeQuery(String hql, Object... values) {
		return executeQuery(null, hql, values);
	}

	public List<T> executeQuery(Pager pager, String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; values != null && i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		if (pager != null) {
			query.setFirstResult((pager.getCurrentPage() - 1)
					* pager.getPageSize());
			query.setMaxResults(pager.getPageSize());
		}
		return query.list();
	}
	
	public long executeCount(String hql , Object... values) {
		Query query = getSession().createQuery("select count(*) " + hql);
		
		for (int i = 0; values != null && i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return (long) query.list().get(0);

	}
}

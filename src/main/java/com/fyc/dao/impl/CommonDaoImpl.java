package com.fyc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fyc.entity.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fyc.dao.CommonDao;

@Repository
@Transactional
public class CommonDaoImpl<T> implements CommonDao<T> {
	
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public List<User> select(String hql) {
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list;
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public void query(T t, Integer id) {
		getSession().get(t.getClass(), id);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public int executeBySql(String sql) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		int result = sqlQuery.executeUpdate();
		
		return result;
	}

	@Override
	public List executeByHql(String hql) {
		Query query = getSession().createQuery(hql);
		List list = query.list();
		
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	
}

package com.fyc.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyc.dao.CommonDao;
import com.fyc.dao.service.UserService;
import com.fyc.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private CommonDao<User> commonDao; 

	@Override
	public void saveUser(User user) {
		this.commonDao.save(user);
	}

	@Override
	public List<User> checkUser(String hql){ return this.commonDao.select(hql); }

	@Override
	public void delUser(User user) {
		this.commonDao.delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> executeByHql(String hql) {
		return this.commonDao.executeByHql(hql);
	}

}

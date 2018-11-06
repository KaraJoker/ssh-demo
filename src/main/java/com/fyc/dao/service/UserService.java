package com.fyc.dao.service;

import java.util.List;

import com.fyc.entity.User;

public interface UserService {
	/**
	 * 新增用户
	 * @date	2018-6-19 下午5:13:45
	 * @author	live
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 展示用户
	 * @date	2018-6-19 下午5:13:45
	 * @author	live
	 * @param user
	 */
	public List<User> checkUser(String hql);
	
	/**
	 * 删除用户
	 * @date	2018-6-28 上午11:44:14
	 * @author	live
	 * @param user
	 */
	public void delUser(User user);
	
	/**
	 * 执行hql
	 * @date	2018-6-28 下午12:03:54
	 * @author	live
	 * @param hql
	 * @return
	 */
	public List<User> executeByHql(String hql);

}

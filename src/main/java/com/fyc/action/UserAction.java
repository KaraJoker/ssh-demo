package com.fyc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.fyc.dao.service.UserService;
import com.fyc.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class UserAction extends ActionSupport {
	
	@Autowired
	private UserService userService;
	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private Integer state;
	
	private String hql;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	/**
	 * 注册测试
	 * @date	2018-6-20 上午9:47:42
	 * @author	live
	 * @return
	 */
	public String saveUser(){
		System.out.println("action......");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		this.userService.saveUser(user);
		state = 1;
		
		return SUCCESS;
	}

	/**
	 * 注册测试
	 * @date	2018-6-20 上午9:47:42
	 * @author	Outcaster
	 * @return
	 */
	public Object checkUser(){
		hql = "from User AS user";
		List<User> userList = this.userService.checkUser(hql);
		Map<String,List<User>> result=new HashMap<String,List<User>>();
		result.put("userList",userList);
		if(userList.size() > 0)
			state = 1;
		else
			state = 0;

		return result;
	}
	
	/**
	 * 删除测试
	 * @date	2018-6-28 上午11:42:14
	 * @author	live
	 * @return
	 */
	public String delUser(){
		User user = new User();
		user.setId(id);
		
		this.userService.delUser(user);
		state = 1;
		
		return SUCCESS;
	}
	
	/**
	 * HQL查询测试
	 * @date	2018-6-28 下午12:12:16
	 * @author	live
	 * @return
	 */
	public String queryUserByHql(){
		hql = "from User where userName = '" + userName + "'";
		List<User> userList = this.userService.executeByHql(hql);
		if(userList.size() > 0)
			state = 1;
		else
			state = 0;
		
		return SUCCESS;
	}
	
}

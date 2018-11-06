package com.fyc.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.fyc.dao.CommonDao;
import com.fyc.dao.impl.CommonDaoImpl;
import com.fyc.entity.User;

public class DaoTest {
	public static void main(String[] args) {
		CommonDao<User> commonDao;
		
		User user = new User();
		user.setUserName("张三");
		user.setPassword("123456");
		
		
	}

}

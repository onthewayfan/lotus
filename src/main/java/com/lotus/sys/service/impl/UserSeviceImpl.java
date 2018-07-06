package com.lotus.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.sys.dao.UserDao;
import com.lotus.sys.dao.jdbc.UserDaoJDBC;
import com.lotus.sys.dto.UserDto;
import com.lotus.sys.service.UserService;


@Service
public class UserSeviceImpl implements UserService{

	@Autowired //自动装配
	private UserDaoJDBC userDaoJDBC;

	@Autowired //自动装配
	private UserDao userDao;
	

	//事务
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Map<String,Object>> getUserJDBC(){
		List<Map<String,Object>> mapList = null;
		
		mapList = userDaoJDBC.getUserJdbc();
		
		return mapList;
	}

	@Override
	public List<UserDto> getUserList(){
		List<UserDto> mapList = null;
		
		mapList = userDao.getUserList();
		
		return mapList;
	}
	@Override
	public UserDto getUserInfo(String id){
		
		UserDto  userInfo = userDao.getUserInfo(id);
		
		return userInfo;
	}

    
}

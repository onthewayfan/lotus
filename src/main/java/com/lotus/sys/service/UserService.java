package com.lotus.sys.service;

import java.util.List;
import java.util.Map;

import com.lotus.sys.dto.UserDto;
  
public interface UserService {
	
	public List<Map<String,Object>> getUserJDBC();

	public List<UserDto> getUserList();
	
	public UserDto getUserInfo(String id);
    
    

}

package com.lotus.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lotus.sys.dto.UserDto;
import com.lotus.sys.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping("/getUserJDBC")
	public List<Map<String, Object>> getUserJDBC(){
		
		logger.info("getUserJDBC");
		
		return  userService.getUserJDBC();
	}
	
	@RequestMapping("/getChinaMap")
	public List<Map<String, Object>> getChinaMap(){
		
		logger.info("getuser");
		
		return  userService.getChinaMap();
	}
	
	
	@RequestMapping("/getUserList")
	public List<UserDto> getUserList(){
		
		logger.info("getUserList");
		
		return  userService.getUserList();
	}
	
	
	@RequestMapping("/getUserInfo")
	public UserDto getUserInfo(@RequestParam String id){
		
		logger.info("getUserInfo");
		
		return  userService.getUserInfo(id);
	}

}

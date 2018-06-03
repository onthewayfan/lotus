package com.lotus;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Stratup;
import com.lotus.sys.dto.UserDto;
import com.lotus.sys.service.MapService;
import com.lotus.sys.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Stratup.class)
public class UserSpringBootTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MapService mapService;
	
	@Test
	public void getUserList(){
		List<UserDto>  mapList = null;
		
		mapList = userService.getUserList();
	
		System.out.println(mapList);
		
	}
	
	@Test
	public void getUserInfo(){
		
		UserDto userInfo = userService.getUserInfo("1");
	
		System.out.println(userInfo);
		
	}
	
	@Test
	public void getMap(){
		
		List<Map> mapList = mapService.getMap();
		
		System.out.println(mapList);
		
	}

	
	

}

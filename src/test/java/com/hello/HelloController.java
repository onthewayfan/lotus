package com.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(){
		String result = "hello word!";
		
		return result;
	}
		

}

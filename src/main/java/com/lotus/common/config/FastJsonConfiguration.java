package com.lotus.common.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice;

@Configuration
@AutoConfigureAfter(DataBaseConfiguration.class)
public class FastJsonConfiguration {
	//解决SpringBoot引入FastJson报错问题：FastJsonpResponseBodyAdvice required a bean of type '[Ljava.lang.String;' that could not be found
	@Bean
	public FastJsonpResponseBodyAdvice fastJsonpResponseBodyAdvice(){
		return new  FastJsonpResponseBodyAdvice("callback","jsonp");
	}
	

}

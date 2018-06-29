package com.lotus.sys.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@RequestMapping("")
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/index")
	public ModelAndView getIndex(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return  mav;
	}
	
	@RequestMapping("/index1")
	public String getIndex1(Model model){
		return  "index";
	}
	

}

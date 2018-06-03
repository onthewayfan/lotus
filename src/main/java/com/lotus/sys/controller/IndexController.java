package com.lotus.sys.controller;


import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("")
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
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

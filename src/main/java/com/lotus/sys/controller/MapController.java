package com.lotus.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lotus.sys.service.MapService;

@RestController
@RequestMapping("map")
public class MapController {
	private static final Logger logger = Logger.getLogger(MapController.class);
	@Autowired
	private MapService mapService;
	
	@RequestMapping("/getMap")
	public List<Map> getMap(){
		logger.info("getMap");
		List<Map> mapList = mapService.getMap();
		return mapList;
	}
	

}

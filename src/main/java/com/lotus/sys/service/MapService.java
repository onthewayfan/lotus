package com.lotus.sys.service;

import java.util.List;
import java.util.Map;

import com.lotus.base.util.Page;


public interface MapService {
	
	public List<Map> getMap();
	
	public Page<Map> getMap(Page page);

}

package com.lotus.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotus.base.util.Page;
import com.lotus.sys.dao.MapDao;
import com.lotus.sys.service.MapService;


@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapDao mapDao;

	@Override
	public List<Map> getMap() {
		List<Map> mapList = mapDao.getMap();
		return mapList;
	}

	@Override
	public Page<Map> getMap(Page page) {
		
		Page<Map> mapPage = mapDao.getMapPage(page);
		
		return mapPage;
	}

}

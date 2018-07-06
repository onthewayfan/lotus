package com.lotus.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.lotus.base.util.Page;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MapDao {
	
	public List<Map> getMap();
	
	public Page<Map> getMapPage(Page page);
	

}

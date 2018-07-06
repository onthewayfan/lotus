package com.lotus.sys.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository //数据访问层bean
public class AreaDaoJDBC {

	private JdbcTemplate jdbcTemplate;


    @Autowired
	public AreaDaoJDBC(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


    public List<Map<String,Object>> getChinaMapJdbc(){
    	String sql = "select * from sh_area";  	
    	return this.jdbcTemplate.queryForList(sql);
    }


	public List<Map<String,Object>> getProvincesJdbc(){
		String sql = "select * from province";
		return this.jdbcTemplate.queryForList(sql);
	}

}

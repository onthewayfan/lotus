package com.lotus.sys.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //数据访问层bean
public class UserDaoJDBC {

	private JdbcTemplate jdbcTemplate;
    @Autowired
	public  UserDaoJDBC(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public List<Map<String,Object>> getUserJdbc(){
    	String sql = "select * from sys_user";  	
    	return this.jdbcTemplate.queryForList(sql);
    }
    
    public List<Map<String,Object>> getChinaMapJdbc(){
    	String sql = "select * from sh_area";  	
    	return this.jdbcTemplate.queryForList(sql);
    }

    
	
}

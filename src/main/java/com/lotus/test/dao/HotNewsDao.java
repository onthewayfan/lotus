package com.lotus.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotNewsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(List<Map<String, Object>> lm) {
		String sql = "INSERT hotnews (id,name) VALUES (?,?);";
		return jdbcTemplate.update(sql,lm);
	}
	
	public int update(List<Map<String, Object>> lm) {
		String sql = "UPDATE hotnews name=? WHERE id = ?;";
		return jdbcTemplate.update(sql);
	}
	
	public List<Map<String, Object>> query(){
		String sql = "SELECT * FROM hotnews ;";
		return jdbcTemplate.queryForList(sql);
	}
	
	public int delete(int id) {
		String sql = "DELETE hotnews WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	
	
	
	
	
	

	
	
	

}

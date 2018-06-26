package com.lotus.base.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import com.lotus.base.common.enums.LikeBySqlEnum;
import com.lotus.base.exception.DaoException;


public interface IBasicDao<T> {

	
	public List<T> getAll() throws DaoException;
	
	
	public List<T> getList(int first,int limit) throws DaoException;
	
	
	public Integer getCount() throws DaoException;
	
	
	public T getObject(Long key) throws DaoException;
	
	
	public void create(T object) throws DaoException;
	
	
	public Long createAndReturnPrimarykey(T object) throws DaoException;
	
	
	public void update(T object) throws DaoException;
	
		
	public void delete(Object key) throws DaoException;
	
	
	public T findOne(Map<String, Object> map) throws DaoException;
	
	
	public T findOne(T object) throws DaoException;
	
	
	public List<T> find(Map<String, Object> map) throws DaoException;
	
	
	public List<T> find(T object) throws DaoException;
	
	
	public List<T> findByIn(Map<String, Object[]> map) throws DaoException;
	
	
	public List<T> findByLike(Map<String, Object> map,LikeBySqlEnum le) throws DaoException;
	
	
	public Page<T> getList() throws DaoException;
	
	
}

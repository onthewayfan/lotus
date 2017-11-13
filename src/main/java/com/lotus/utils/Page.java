package com.lotus.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junwei.fan on 2017/3/18.
 */
public class Page<T> implements Serializable{
	
	/**
	 * 分页类
	 */
	private static final long serialVersionUID = -5206344681600151820L;

	private int totalRows;//总条数
	
	private int totalPages;//总页数

    private int limit;//页面大小{(pageSize)(-1 时 不分页)}

    private int offset;//起始条(startRow)
    
    private int endRow;//结束条
    
    private int currentPage;//当前页码

    private String search;//查询字段

    private String sort;//排序字段

    private String order;//正序或倒序（asc/desc）
    
    private List<T> resultList = new ArrayList<T>(); //查询信息

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

    
	
}

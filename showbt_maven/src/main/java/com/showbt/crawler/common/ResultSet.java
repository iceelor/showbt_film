package com.showbt.crawler.common;

import java.util.List;

public class ResultSet<T> {
	/**
	 * 每页多少条数据
	 */
	private int pageSize = 20;
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	/**
	 * 总页数
	 */
	private int maxPage;
	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 结果集
	 */
	private List<T> results;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		if(currentPage<1){
			currentPage =1;
		}
		if(currentPage>getMaxPage()){
			currentPage = getMaxPage();
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxPage() {
		if(totalRecord%pageSize==0){
			maxPage = totalRecord/pageSize;
		}else{
			maxPage = totalRecord/pageSize;
			maxPage += 1;
		}
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}

	
}

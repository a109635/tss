package com.baizhi.util;
/*
 * 分页
 */
public class Page {
	//当前页数
	private int pageIndex;
	//每一页展示条数
	private int pageSize;
	//总页数
	private int pageCount;
	public Page() {
	}
	public Page(int pageIndex, int pageSize, int pageCount) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	//总页数
	public int pageCounts(int count){
		return pageCount=count/pageSize==0?pageCount:count/pageSize+1;
	}
	
	
	//是否是第一页
	public boolean pageFirst(int pageindex){
		if(pageindex==1){
			return false;
		}
		return true;
	}
	//是否是最后一页
	public boolean pageLast(int pageindex){
		if(pageindex==pageCount){
			return false;
		}
		return true;
	}
}

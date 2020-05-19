package com.communication.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component 
@Scope("prototype")
public class Pager implements Serializable{


	private static final long serialVersionUID = 1L;
	private int currentPage = 1;	       //当前页面
	private int pageSize = 15;	           //一页的条数
	private long totalSize = 0;            //总的条数
	private int totalPage = 1;             //总的页数
	
	private boolean hasFirst;         
	private boolean hasPrevious;
	private boolean hasNext;
	private boolean hasLast;
	
	
	private List<Integer> showPageNumList = new ArrayList<Integer>();   //分页下标页号码，类似：[1]  [2]  [3]  4  [5]  [6]  [7]，nearbyPage[0]无效
	private int showPageNumList_maxLength=7; //showPageNumList的最长长度
//	private int nearbyPages_realLength=0;    
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		try{
			int page = Integer.parseInt(currentPage);
			if(page > 0)
				this.currentPage = page;
		}catch(Exception e){
		}
	}
	public boolean getHasFirst() {
		return currentPage == 1 ? false : true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	public boolean getHasLast() {
		return currentPage == getTotalPage() ? false : true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	public boolean getHasNext() {
		return getHasLast() ? true : false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean getHasPrevious() {
		return getHasFirst() ? true : false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		try{
			int size = Integer.parseInt(pageSize);
			if(size > 0 && size < 1000)
				this.pageSize = size;
		}catch(Exception e){
		}
	}
	public int getTotalPage() {
		totalPage = (int)(totalSize / pageSize);
		if(totalSize % pageSize != 0)
			totalPage++;
		totalPage = totalPage==0?1:totalPage;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		if(totalSize>-1)
			this.totalSize = totalSize;
		currentPage = currentPage > getTotalPage() ? getTotalPage() : currentPage;
	}
	
	
	
	
	/*********************  czs *************************/
	public int getShowPageNumList_maxLength() {
		return showPageNumList_maxLength;
	}

	public void setShowPageNumList_maxLength(int showPageNumList_maxLength) {
		this.showPageNumList_maxLength = showPageNumList_maxLength;
	}
	
	
	//有修改
	public List<Integer> getShowPageNumList() {
		//初始化
		showPageNumList = new ArrayList<Integer>();
		
		
		if(this.getTotalPage()<=this.getShowPageNumList_maxLength()){            //1、最多只有showPageNumList_maxLength个页下标，把所有的页都罗列出来
			
		//	System.out.println("pager           1");
			
			for(int i=1;i<=this.getTotalPage();i++){
				showPageNumList.add(i);
			}				
		}
		else{                                                                    //2、页下标个数超过showPageNumList_maxLength个				
			if(this.getCurrentPage()-1 < this.getShowPageNumList_maxLength()/2){ //2.1、当前页面前面的页下标个数少于showPageNumList_maxLength的一半
				
		//		System.out.println("pager           2.1");

				
				//从第一个开始装
				for(int i=1;i<=this.getShowPageNumList_maxLength();i++){
					showPageNumList.add(i);					
				}					
			}
			else if(this.getTotalPage()-this.getCurrentPage()<this.getShowPageNumList_maxLength()/2){ //2.2、当前页面后面的页下标个数少于showPageNumList_maxLength的一半
				//最后的	showPageNumList_maxLength个
				
		//		System.out.println("pager           2.2");

				
				for(int i=1,j=this.getTotalPage()-this.getShowPageNumList_maxLength()+1;  i<=this.getShowPageNumList_maxLength();  i++,j++){
					showPageNumList.add(j);					
				}				
			}
			else{                                                             //2.3、当前页面前后的页下标个数都少于showPageNumList_maxLength的一半
					
		//	    System.out.println("pager           2.3");

	            for(int i=1,j=this.getCurrentPage()-this.getShowPageNumList_maxLength()/2;i<=this.getShowPageNumList_maxLength();i++,j++){
	            	showPageNumList.add(j);									
				}
			}				
		}
		
		
		return showPageNumList;
	}
}


package com.other;


public class TestPage {
	public static void main(String[] args) {
		int totalNumber = 50;//总条数
		int limit  = 8;//每页大小
		int offset = 56;//当前第几条
		int totalPage = 0;//总页数
		int pageNumber = 0;//当前第几页
		
//		Page  page = new Page();
//		
//		page.setLimit(limit);
//		
//		page.setOffset(offset);
		

		
		// 已知 每页大小、当前第几条 --> 当前页
		if(offset>totalNumber){
			offset = totalNumber;
		}
		
		if(limit>=1){
			if(totalNumber%limit==0){
				totalPage = totalNumber/limit;
			}else{
				totalPage = totalNumber/limit+1;
			}
			if(offset%limit==0){
				pageNumber = offset/limit;
			}else{
				pageNumber = offset/limit+1;
			}			
		}else if(limit==0){
			totalPage = totalNumber;
			pageNumber = offset;
		}
		
		//已知 每页大小 、当前页数 --> 当前条数的取值范围
		
		System.out.println("总条数："+totalNumber+",总页数："+totalPage+",每页大小："+limit+",当前页："+pageNumber+",当前条数："+offset);
		
		
	}

}

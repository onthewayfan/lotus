package com.leecode;

import java.util.Arrays;

public class Solution {
     public int[] twoSum(int[] nums,int target) {
    	 int[] indexs = new int[]{-1,-1};
    	 for (int i = 0; i < nums.length; i++) {
    		    int v = target-nums[i];
    		    for (int j = 0; j < nums.length; j++) {
    		    	if(i==j) {
    		    		continue;
    		    	}
    		    	if(v-nums[j]==0) {
    		    		indexs[0]=i;
    		    		indexs[1]=j;
    		    		break;
    		    	}
    		    }
    		    if(indexs[0]!=-1&&indexs[1]!=-1) {
    		    	break;
    		    	//System.out.println(Arrays.toString(indexs));
    		    }
    		    
		 }
		return indexs;
     }
     
     
     public static void main(String[] args) {
    	 int[] nums= {1,9,12,2,7,3,7,68,99};
    	 int target=102;
    	 System.out.println("Test:"+Arrays.toString(new Solution().twoSum(nums, target)));

	 }
}

package com.other;

class num<T>{
	
}

public class TestDame {
	
	public static void main(String[] args) {
		System.out.println(add(1,2,3,4,5));
	}

	
	public static int add(int... a) {
		int sum=0;
		if(a.length>0) {
			for(int i:a) {
				sum+=i;
			}
		}
		
		return sum;
	}
}

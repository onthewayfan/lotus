package com;

public class TestThread {
	public static void main(String[] args) {
		
		Thread myThread = new Thread(()->System.out.println("test thread"));
		System.out.println("before myThread ...status:"+myThread.getState());
		int i = 0;
		myThread.start();
		System.out.println("in-1 myThread ...status:"+myThread.getState());
		while (true) {
			i++;
			if (!myThread.isAlive()) {
				System.out.println("after myThread ...status:"+myThread.getState());	
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		System.out.println(i);
		
		
		
	}
}

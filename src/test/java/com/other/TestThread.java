package com.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		
		
		ExecutorService executorService0 = Executors.newCachedThreadPool();//创建线程池（多个线程）
		
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();//创建线程池 （单个线程）
		
		ExecutorService executorService2 = Executors.newScheduledThreadPool(3);//创建线程池 （指定线程3）
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);//创建带定时任务的线程池

		for (int j = 0; j < 5; j++) {
			int index = j;
			executorService0.submit(()->{
				System.out.println(Thread.currentThread().getName()+",x="+index);
			});
		}
		executorService0.shutdown();
		
		for (int j = 0; j < 5; j++) {
			int index = j;
			scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+",x="+index);
				}
			}, 3, 2, TimeUnit.SECONDS);
		}
		scheduledExecutorService.shutdown();
	

		System.currentTimeMillis();
	}
}

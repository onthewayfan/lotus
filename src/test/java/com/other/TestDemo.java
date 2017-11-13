package com.other;

import java.lang.reflect.Executable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

class MyThread extends Thread {
	private String title;
	@Override
	public void run() {
		System.out.println(this.title);;
	}
	public MyThread(String title) {
		this.title = title;
	}
}

class MyThread1 implements Runnable{
	private String title;
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+",i="+i);
		}
		System.out.println(this.title);;
	}
	public MyThread1(String title) {
		this.title = title;
	}
}


class MyThread2 implements Callable<String>{
	private String title;
	public MyThread2(String title) {
		this.title = title;
	}
	@Override
	public String call() throws Exception {
		System.out.println(this.title);;
		return this.title;
	}
}

public  class TestDemo {
	public static void main(String[] args) {
		Function<Integer,String> o = String::valueOf;
		o.apply(90);
		
		System.out.println(o.toString());
		MyThread myThread = new MyThread("线程A");
		myThread.start();
		
		MyThread2 myThread2 = new MyThread2("线程C");
		FutureTask<String> task = new FutureTask<String>(myThread2);
		new Thread(task).start();
		System.out.println(myThread2);
		
		MyThread1 myThread1 = new MyThread1("线程B");
		Thread t1= new Thread(myThread1,"线程1");
		Thread t2= new Thread(myThread1,"线程2");
		Thread t3= new Thread(myThread1,"线程3");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.notify();
		
		ThreadPoolExecutor threadPoolExecutor =new ThreadPoolExecutor(0, 0, 0, null, null);
		
		//ExecutorService
	}
  }
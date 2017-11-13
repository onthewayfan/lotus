package com.date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

public class TestDate {
	private static ThreadLocal<SimpleDateFormat> SDFLocal = new ThreadLocal<SimpleDateFormat>(){
		@Override
		public SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
    @Test
    public void sdf() {
		sdfSyn();
		sdfNsyn();
    	new Thread(()->{
    		System.out.println("进入线程A******************");
    		sdfSyn();
    		sdfNsyn();
    		System.out.println("结束线程A******************");
    	},"线程A").start();
    	new Thread(()->{
    		System.out.println("进入线程B******************");
    		sdfSyn();
    		sdfNsyn();
    		System.out.println("结束线程B******************");
    	},"线程B").start();
    	new Thread(()->{
    		System.out.println("进入线程C******************");
    		sdfSyn();
    		sdfNsyn();
    		System.out.println("结束线程C******************");
    	},"线程C").start();
    	new Thread(()->{
    		System.out.println("进入线程D******************");
    		sdfSyn();
    		sdfNsyn();
    		System.out.println("结束线程D******************");
    	},"线程D").start();
    	new Thread(()->{
    		System.out.println("进入线程E******************");
    		sdfSyn();
    		sdfNsyn();
    		System.out.println("结束线程E******************");
    	},"线程E").start();
    }
    
    public void sdfSyn() {
    	SimpleDateFormat sdf = SDFLocal.get();
    	try {
			Thread.sleep(new Random().nextInt(10)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String dt = sdf.format(Calendar.getInstance().getTime());
    	System.out.println("sdfSyn:"+dt);
    }
    
    public void sdfNsyn() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try {
			Thread.sleep(new Random().nextInt(10)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String dt = sdf.format(Calendar.getInstance().getTime());
    	System.out.println("sdfNsyn:"+dt);
    }

}

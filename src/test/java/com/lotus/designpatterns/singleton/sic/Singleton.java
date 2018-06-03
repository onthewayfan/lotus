package com.lotus.designpatterns.singleton.sic;

/**
 * 登记式/静态内部类
 * @author fjw
 *
 */
public class Singleton {
	private static class SingletonHolder{
		private static final Singleton INSTANCE = new Singleton(); 
	}
	
	private Singleton() {};
	
	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}


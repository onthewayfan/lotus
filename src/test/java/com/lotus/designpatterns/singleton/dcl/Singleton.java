package com.lotus.designpatterns.singleton.dcl;

/**
 * 双检锁(DCL)
 * @author fjw
 *
 */
public class Singleton {
	private volatile static Singleton singleton;
	private Singleton() {};
	public static Singleton getInstance() {
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton = new Singleton();
				}
				
			}
		}
		return singleton;
	}
}




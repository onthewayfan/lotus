package com.lotus.base.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ServiceException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9115437185401870275L;
	
	private Throwable nestedThrowable = null;
		
	public ServiceException() {
		super();
	}
	
	public ServiceException(String msg) {
		super(msg);
	}
	
	
	public ServiceException(Throwable throwable) {
		this.nestedThrowable = throwable;
	}
	
	public ServiceException(String msg,Throwable throwable) {
		super(msg);
		this.nestedThrowable = throwable;
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		if(nestedThrowable!=null) {
			nestedThrowable.printStackTrace();
		}
	}
	
	@Override
	public void printStackTrace(PrintStream ps) {
		super.printStackTrace(ps);
		if(nestedThrowable!=null) {
			nestedThrowable.printStackTrace(ps);
		}
	}
	
	@Override
	public void printStackTrace(PrintWriter pw) {
		super.printStackTrace(pw);
		if(nestedThrowable!=null) {
			nestedThrowable.printStackTrace(pw);
		}
	}



	
	
	

	
	
	
	
	
	
}

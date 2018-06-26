package com.lotus.base.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8213546168480435838L;
	
	private Throwable nestedThrowable = null;
	
	
	public DaoException() {
		super();
	}
	
	public DaoException(String msg) {
		super(msg);
	}
	
	
	public DaoException(Throwable throwable) {
		this.nestedThrowable = throwable;
	}
	
	public DaoException(String msg,Throwable throwable) {
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

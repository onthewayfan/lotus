package com.lotus.base.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class TransactionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8008976968620785959L;
	private Throwable nestedThrowable = null;
		
	public TransactionException() {
		super();
	}
	
	public TransactionException(String msg) {
		super(msg);
	}
	
	
	public TransactionException(Throwable throwable) {
		this.nestedThrowable = throwable;
	}
	
	public TransactionException(String msg,Throwable throwable) {
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

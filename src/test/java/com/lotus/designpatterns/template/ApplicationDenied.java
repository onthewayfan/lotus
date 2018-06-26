package com.lotus.designpatterns.template;

public class ApplicationDenied extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = -868416991578012809L;

	public ApplicationDenied() {
        super();
    }

    public ApplicationDenied(String message) {
        super(message);
    }
	
	
}

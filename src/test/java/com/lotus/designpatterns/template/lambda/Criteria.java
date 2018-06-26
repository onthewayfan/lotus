package com.lotus.designpatterns.template.lambda;

import com.lotus.designpatterns.template.ApplicationDenied;

public interface Criteria {

	public void check() throws ApplicationDenied;
	
}

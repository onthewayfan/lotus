package com.lotus.designpatterns.template.lambda;

import com.lotus.designpatterns.template.ApplicationDenied;

public interface Company {
	
	public void checkIdentity() throws ApplicationDenied;
	
	public void checkProfitAndLoss() throws ApplicationDenied;
	
	public void checkHistoricalDebt() throws ApplicationDenied;

}

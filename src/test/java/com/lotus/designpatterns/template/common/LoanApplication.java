package com.lotus.designpatterns.template.common;

import com.lotus.designpatterns.template.ApplicationDenied;

public abstract class LoanApplication {

	public void checkLoanApplication() throws ApplicationDenied{
		  checkIdentity();
		
	}
	
	protected abstract void checkIdentity() throws ApplicationDenied;
	
	protected abstract void checkCreditHistory() throws ApplicationDenied;
	
	protected abstract void checkIncomeHistory() throws ApplicationDenied;
	
	private void reportFindings() {
		
		
	};
	
}

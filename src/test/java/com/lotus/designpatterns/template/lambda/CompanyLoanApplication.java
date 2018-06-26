package com.lotus.designpatterns.template.lambda;

public class CompanyLoanApplication extends LoanApplication{

	public CompanyLoanApplication(Company company) {
		super(company::checkIdentity,
			  company::checkHistoricalDebt,
			  company::checkProfitAndLoss);
	}
	
}

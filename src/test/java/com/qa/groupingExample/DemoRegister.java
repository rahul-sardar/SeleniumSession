package com.qa.groupingExample;

import org.testng.annotations.Test;

public class DemoRegister {

	@Test(groups = { "smoke", "sanity", "Regression", "register", "all" })
	public void registerByProvidingOnlyMandatoryFields() {
		System.out.println("registerByProvidingOnlyMandatoryFields - DemoRegister");
	}

	@Test(groups = { "smoke", "sanity", "Regression", "register", "all" })
	public void registerByProvidingAllFields() {
		System.out.println("registerByProvidingAllFields - DemoRegister");
	}

	@Test(groups = { "sanity", "Regression", "register", "all" })
	public void registerByNotProvidingAnyFields() {
		System.out.println("registerByNotProvidingAnyFields - DemoRegister");
	}

	@Test(groups = { "smoke", "sanity", "Regression", "register", "all" })
	public void registerByProvidingDuplicateEmailAddress() {
		System.out.println("registerByProvidingDuplicateEmailAddress - DemoRegister");
	}

}

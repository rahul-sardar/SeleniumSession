package com.qa.packagelevelrunning.example;

import org.testng.annotations.Test;

public class DemoRegister {

	@Test(priority=1)
	public void registerByProvidingOnlyMandatoryFields() {
		System.out.println("registerByProvidingOnlyMandatoryFields - DemoRegister");
	}

	@Test(priority=2)
	public void registerByProvidingAllFields() {
		System.out.println("registerByProvidingAllFields - DemoRegister");
	}

	@Test(priority=4)
	public void registerByNotProvidingAnyFields() {
		System.out.println("registerByNotProvidingAnyFields - DemoRegister");
	}

	@Test(priority=6)
	public void registerByProvidingDuplicateEmailAddress() {
		System.out.println("registerByProvidingDuplicateEmailAddress - DemoRegister");
	}

}

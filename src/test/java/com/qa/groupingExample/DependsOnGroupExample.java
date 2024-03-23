package com.qa.groupingExample;

import org.testng.annotations.Test;

public class DependsOnGroupExample {
	
	@Test(groups = { "smoke"})
	public void loginWithValidCredential() {
		System.out.println("loginwithValidCredentials - DemoLogin");
	}

	@Test(groups = { "smoke"})
	public void logibWithInvalidEmailandInvalidPassword() {
		int a= 5/0;
		System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin ");

	}

	@Test(groups = {  "Regression"})
	public void logibWithInvalidEmailandValidPassword() {
		System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin");

	}

	@Test(groups = {"sanity" })
	public void loginWithInvalidCredentials() {
		System.out.println("loginWithInvalidCredentials - DemoLogin -->" + Thread.currentThread().getId());

	}

	@Test( groups = {"depend"}, dependsOnGroups = { "smoke", "Regression" })
	public void AloginWithoutProvidingCredentials() {
		System.out.println("AloginWithoutProvidingCredentials - DemoLogin");

	}
	/*
	 * Once all the group mention in the dependsongroup runs then only this
	 * dependsOngroup will run Intentionally 'A' character is given in last method
	 * name to see what's the order of running if we dont give dependongroup tag
	 * 
	 */

}

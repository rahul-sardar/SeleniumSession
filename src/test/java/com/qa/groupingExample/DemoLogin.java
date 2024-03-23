package com.qa.groupingExample;

import org.testng.annotations.Test;

public class DemoLogin {
	@Test(groups = { "smoke", "sanity", "Regression", "login", "all" })
	public void loginWithValidCredential() {
		System.out.println("loginwithValidCredentials - DemoLogin");
	}

	@Test(groups = { "smoke", "sanity", "Regression", "login", "all" })
	public void logibWithInvalidEmailandInvalidPassword() {
		System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin ");

	}

	@Test(groups = { "smoke", "sanity", "Regression", "login", "all" })
	public void logibWithInvalidEmailandValidPassword() {
		System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin");

	}

	@Test(groups = { "smoke", "sanity", "Regression", "login", "all" })
	public void loginWithInvalidCredentials() {
		System.out.println("loginWithInvalidCredentials - DemoLogin -->" + Thread.currentThread().getId());

	}

	@Test(groups = { "smoke", "sanity", "Regression", "login", "all" })
	public void loginWithoutProvidingCredentials() {
		System.out.println("loginWithoutProvidingCredentials - DemoLogin");

	}

}

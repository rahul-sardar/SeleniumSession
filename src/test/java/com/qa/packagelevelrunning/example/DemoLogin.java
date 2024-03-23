package com.qa.packagelevelrunning.example;

import org.testng.annotations.Test;

public class DemoLogin {
	@Test(priority=1)
	public void loginWithValidCredential() {
		System.out.println("loginwithValidCredentials - DemoLogin");
	}

	@Test(priority=2)
	public void logibWithInvalidEmailandInvalidPassword() {
		System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin ");

	}

	@Test(priority=3)
	public void logibWithInvalidEmailandValidPassword() {
		System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin");

	}

	@Test(priority=5)
	public void loginWithInvalidCredentials() {
		System.out.println("loginWithInvalidCredentials - DemoLogin -->");

	}

	@Test(priority=9)
	public void loginWithoutProvidingCredentials() {
		System.out.println("loginWithoutProvidingCredentials - DemoLogin");

	}

}

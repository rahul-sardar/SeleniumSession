package com.listeners.example;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTestCheckingListener {
	@Test(priority = -1)
	public void loginWithValidCredential() {
		System.out.println("loginwithValidCredentials - DemoLogin -->");
	}

	@Test(priority = 0, timeOut=1000)
	public void loginWithInvalidEmailandInvalidPassword() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin -->");

	}

	@Test(priority = 1)
	public void logibWithInvalidEmailandValidPassword() {
		System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin -->");

	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
		System.out.println("loginWithInvalidCredentials - DemoLogin -->");

	}

	@Test(priority = 3, dependsOnMethods = {"loginWithInvalidEmailandInvalidPassword"})
	public void loginWithoutProvidingCredentials() {
		System.out.println("loginWithoutProvidingCredentials - DemoLogin -->");

	}
	
	/*
	 * How to connect Listeners class with this login class? We have to use
	 * annotation.
	 * 
	 * @Listeners({MyLiseners.class})--> We have to provide ;listener class name
	 * here, If multiple classes are there to listen then all those name we have to
	 * provide in comma separated form
	 * 
	 * We have failed one tc's here and one will get skipped bcoz of depends on methods to see when 
	 * failed with timeout listener method get invoked
	 * 
	 * Now if we have connect this listener with other classes then we have provide this annotation in 
	 * every class. Not a good approach. So we can provide the listeners in .xml file
	 */

}

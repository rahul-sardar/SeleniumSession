package com.qa.parallelexecution.example;

import org.testng.annotations.Test;

public class DemoLogin {
	@Test(priority = -1)
	public void loginWithValidCredential() {
		System.out.println("loginwithValidCredentials - DemoLogin -->" + Thread.currentThread().getId());
	}

	@Test(priority = 0)
	public void logibWithInvalidEmailandInvalidPassword() {
		System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin -->" + Thread.currentThread().getId());

	}

	@Test(priority = 1)
	public void logibWithInvalidEmailandValidPassword() {
		System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin -->" + Thread.currentThread().getId());

	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
		System.out.println("loginWithInvalidCredentials - DemoLogin -->" + Thread.currentThread().getId());

	}

	@Test(priority = 3)
	public void loginWithoutProvidingCredentials() {
		System.out.println("loginWithoutProvidingCredentials - DemoLogin -->" + Thread.currentThread().getId());

	}

	/*
	 * In sequential execution the test gets executed one after the other
	 * Thread.currentThread().getId() -- we are using this to see what is the thread
	 * id used for each test execution . In multitasking we have multiple thread
	 * which will excute test in parallel
	 * 
	 * Just to proof only single thread is executing all the methods we are printing
	 * thread id.
	 */

}

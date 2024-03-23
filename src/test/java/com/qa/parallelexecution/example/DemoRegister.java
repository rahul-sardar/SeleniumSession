package com.qa.parallelexecution.example;

import org.testng.annotations.Test;

public class DemoRegister {

	@Test(priority = 1)
	public void registerByProvidingOnlyMandatoryFields() {
		System.out
				.println("registerByProvidingOnlyMandatoryFields - DemoRegister -->" + Thread.currentThread().getId());
	}

	@Test(priority = 2)
	public void registerByProvidingAllFields() {
		System.out.println("registerByProvidingAllFields - DemoRegister -->" + Thread.currentThread().getId());
	}

	@Test(priority = 3)
	public void registerByNotProvidingAnyFields() {
		System.out.println("registerByNotProvidingAnyFields - DemoRegister -->" + Thread.currentThread().getId());
	}

	@Test(priority = 4)
	public void registerByProvidingDuplicateEmailAddress() {
		System.out.println(
				"registerByProvidingDuplicateEmailAddress - DemoRegister -->" + Thread.currentThread().getId());
	}

}

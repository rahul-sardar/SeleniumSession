package com.qa.packagelevelrunning.example;

import org.testng.annotations.Test;

public class DemoSearch {

	@Test(priority=1)
	public void searchForAValidProduct() {
		System.out.println("searchForAValidProduct- DemoSearch");

	}

	@Test(priority=2)
	public void searchForAInvalidProduct() {
		System.out.println("searchForAInvalidProduct- DemoSearch");

	}

	@Test(priority=4)
	public void searchWithoutAnySearchItem() {
		System.out.println("searchWithoutAnySearchItem- DemoSearch");

	}
}

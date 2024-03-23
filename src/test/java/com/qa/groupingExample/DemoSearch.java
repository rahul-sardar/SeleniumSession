package com.qa.groupingExample;

import org.testng.annotations.Test;

public class DemoSearch {

	@Test(groups = { "smoke", "sanity", "Regression", "search", "all" })
	public void searchForAValidProduct() {
		System.out.println("searchForAValidProduct- DemoSearch");

	}

	@Test(groups = { "sanity", "Regression", "search", "all" })
	public void searchForAInvalidProduct() {
		System.out.println("searchForAInvalidProduct- DemoSearch");

	}

	@Test(groups = { "sanity", "Regression", "search", "all" })
	public void searchWithoutAnySearchItem() {
		System.out.println("searchWithoutAnySearchItem- DemoSearch");

	}
}

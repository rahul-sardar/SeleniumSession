package com.qa.parallelexecution.example;

import org.testng.annotations.Test;

public class DemoSearch {
	@Test(priority=1)
	  public void searchForAValidProduct() {
		  System.out.println("searchForAValidProduct- DemoSearch -->" +Thread.currentThread().getId());
		  
	  }
	  
	  @Test(priority=2)
	  public void searchForAInvalidProduct() {
		  System.out.println("searchForAInvalidProduct- DemoSearch -->" +Thread.currentThread().getId());
		  
	  }
	  
	  @Test(priority=3)
	  public void searchWithoutAnySearchItem() {
		  System.out.println("searchWithoutAnySearchItem- DemoSearch -->" +Thread.currentThread().getId());
		  
	  }
}

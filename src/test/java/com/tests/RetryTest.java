package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	
	
	@Test(priority = 1 )
    public void test() {
        //Passing Scenario
        Assert.assertEquals(2+2,4,"Addition Problem! 2+2 must be 4!\n");
    }
    
	@Test(priority = 2 )
    public void test1() {
        //Passing Scenario
        Assert.assertEquals(2+2,5,"Addition Problem! 2+2 must be 4!\n");
    }

	
	@Test(priority = 3 )
	public void methodFail()
	{
		    //Failing Scenario
			System.out.println("Failing method purposefully.");
			Assert.fail("Purposefully failing");	
	}
}

package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {
	
	

    @Test(groups= {"GroupA"})
    public void testMethod6() {
        System.out.println("TestMethod6: Executing test method 6.");
        int[] numbers = {1, 2, 3, 4, 5};
        Assert.assertEquals(numbers.length, 5);
    }

    @Test(groups= {"GroupB"})
    public void testMethod7() {
        System.out.println("TestMethod7: Executing test method 7.");
        String str = "TestNG";
        Assert.assertTrue(str.contains("NG"));
    }

    @Test(groups= {"GroupA"})
    public void testMethod8() {
        System.out.println("TestMethod8: Executing test method 8.");
        Assert.assertNotNull(new Object());
    }

    @Test(groups= {"GroupA"})
    public void testMethod9() {
        System.out.println("TestMethod9: Executing test method 9.");
        double result = 10 / 2;
        Assert.assertEquals(result, 5.0);
    }

    @Test(groups= {"GroupA"})
    public void testMethod10() {
        System.out.println("TestMethod10: Executing test method 10.");
        Assert.fail("This test method intentionally fails.");
    }

}

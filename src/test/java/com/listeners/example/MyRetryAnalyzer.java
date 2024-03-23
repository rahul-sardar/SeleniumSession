package com.listeners.example;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private static int maxTry = 3;

	@Override
	public boolean retry(ITestResult iTestResult) {

		if (count < maxTry) { // Check if max try count is reached
			count++; // Increase the maxTry count by 1

			return true; // Tells TestNG to re-run the test
		}
		return false;
	}

}

/*
 * Now whichever method fails we can goto that class and add retyrAnalyzer attribute to that method
 * 
 * @Test(priority=1, retryAnalyzer= com.listeners.example.MyRetryAnalzyer.class)
 * This extra annotation we need to add for every fail test cases...
 * 
 * Now goto every method and adding this annotation is time taking process, we can provide this annotation to every test methods 
 * but instead of that we can use IAnnotationTransformer interface.
 * Check MyAnnotationTransformer.java file
 * 
 * IRetryAnalyzer is an interface in TestNG that allows you to implement retry logic for failed test cases. In simple terms, it provides a way to rerun a failed test case a certain number of times before marking it as a failure.

Here's how IRetryAnalyzer works:

Interface Definition: IRetryAnalyzer is an interface provided by TestNG that you can implement in your Java code.

Retry Logic: When a test case fails during execution, TestNG checks if the test class or method is configured with
an IRetryAnalyzer. If so, TestNG calls the retry() method of the IRetryAnalyzer implementation associated with that
test class or method.

Customization: You can customize the retry() method implementation to decide whether the failed test should be retried
or not. Typically, you specify a maximum retry count. If the retry() method returns true, TestNG reruns the failed test 
again. If it returns false or the maximum retry count is reached, TestNG considers the test case as a failure.

Annotation Usage: To use IRetryAnalyzer, you annotate your test class or test method with @RetryAnalyzer and provide the 
implementation class that implements IRetryAnalyzer.
 * 
 */
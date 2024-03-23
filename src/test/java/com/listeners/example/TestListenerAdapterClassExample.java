package com.listeners.example;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListenerAdapterClassExample extends TestListenerAdapter{

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		System.out.println("Inside onTest Start Method, "+ testName +  " started ");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		System.out.println("Inside onTest Success Method, "+ testName +  " Passed ");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		System.out.println("Inside onTest Failure Method, "+ testName +  " Failed with timeout");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println("Inside onTest Skipped Method, "+ testName +  " Skipped ");
		
	}
	
	

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String testName = result.getName();
		System.out.println("Inside onTestFailedWithTimeout Method, "+ testName +  " Failed ");
	}


	@Override
	public void onStart(ITestContext context) {
		System.out.println("on Start Method - Test Execution  Started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Method - Test Execution  Finished");
		
	}
	

}

//Now In Xml we can add the <Listeners> tag and provide this class name.



/*
 * The TestListenerAdapter class implements several listener interfaces such as
 * ITestListener, ISuiteListener, IInvokedMethodListener, and more, making it
 * versatile for handling different types of events.
 * 
 * The TestListenerAdapter class and ITestListener interface are both related to
 * listening to events during TestNG test execution, but they serve slightly
 * different purposes.
 * 
 * TestListenerAdapter Class: The TestListenerAdapter class is a convenience
 * class provided by TestNG that implements various listener interfaces
 * (ITestListener, ISuiteListener, IInvokedMethodListener, etc.). It acts as an
 * adapter between your custom listener and the TestNG framework, allowing you
 * to override only the methods you're interested in without implementing all
 * methods from the listener interfaces directly. You extend the
 * TestListenerAdapter class and override specific methods to handle test
 * events. This makes it easier to create custom listeners as you only need to
 * focus on the events you want to capture.
 * 
 * But now in latest testNG libraries all the methods defined in ITestListeners are
 * default method so no restriction of overriding for all the methods. But
 * TestListenerAdapter implements lots of listeners interface so we have a good
 * option to override only those method which we needed.
 * 
 * ITestListener Interface: The ITestListener interface is a core interface
 * provided by TestNG that defines methods to handle test events during the test
 * execution life cycle. When you implement the ITestListener interface directly,
 * you need to provide implementations for all methods defined in the interface,
 * even if you're interested in only a subset of events. It gives you more
 * control and flexibility over handling test events, but requires you to
 * implement all methods specified in the interface.
 * 
 * The TestListenerAdapter class is a pre-implemented adapter class that allows
 * you to create custom listeners by extending it and overriding specific
 * methods. The ITestListener interface is a core TestNG interface that you
 * implement directly to handle test events, giving you more control but
 * requiring implementations for all methods in the interface. Use
 * TestListenerAdapter when you want a more straightforward way to create custom
 * listeners by focusing on specific events, and use ITestListener when you need
 * fine-grained control over all test events.
 */
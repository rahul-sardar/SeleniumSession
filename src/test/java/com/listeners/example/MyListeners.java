package com.listeners.example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	
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

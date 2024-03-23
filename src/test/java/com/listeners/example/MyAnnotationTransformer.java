package com.listeners.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import ListeneresDemo.retrySetUp;

public class MyAnnotationTransformer implements IAnnotationTransformer{
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(com.listeners.example.MyRetryAnalyzer.class);
		
	}

}


/*
 * The IAnnotationTransformer interface in TestNG allows you to dynamically
 * modify or transform annotations at runtime. In simpler terms, it provides a
 * way to change the behavior of test methods or classes before they are
 * executed by TestNG.
 * 
 * Here's how it works:
 * 
 * Interface Definition: IAnnotationTransformer is an interface provided by
 * TestNG that you can implement in your Java code.
 * 
 * Annotation Transformation: When TestNG starts executing tests, it checks if
 * any classes implement the IAnnotationTransformer interface. If so, it calls
 * the transform() method provided by the interface.
 * 
 * Dynamic Changes: Inside the transform() method, you can programmatically
 * modify or replace annotations on test classes, test methods, configuration
 * methods (@BeforeXXX, @AfterXXX), and more based on certain conditions or
 * logic.
 * 
 * Use Cases: Common use cases for IAnnotationTransformer include: Changing the
 * priority or groups of test methods dynamically. Skipping or enabling certain
 * tests based on external conditions. Adding custom annotations or attributes
 * to tests at runtime. Modifying configurations or behaviors of tests
 * on-the-fly.
 * 
 * 
 * Changing the priority or groups of test methods dynamically:

		 * public class AnnotationTransformerExample implements IAnnotationTransformer {
			    @Override
			    public void transform(ITestAnnotation annotation, Class testClass,
			                          Constructor testConstructor, Method testMethod) {
			        if (testMethod.getName().equals("testMethod")) {
			            annotation.setPriority(1); // Change priority to 1
			            annotation.setGroups(new String[]{"smoke"}); // Add "smoke" group
			        }
			    }
			}

Modifying configurations or behaviors of tests on-the-fly:
			public class AnnotationTransformerExample implements IAnnotationTransformer {
				    @Override
				    public void transform(ITestAnnotation annotation, Class testClass,
				                          Constructor testConstructor, Method testMethod) {
				        if (testMethod.getName().equals("testMethod")) {
				            annotation.setTimeOut(5000); // Set timeout to 5 seconds
				            annotation.setAlwaysRun(true); // Always run the test method
				        }
				    }
			 }
			 

Skipping or enabling certain tests based on external conditions:			 
			public class AnnotationTransformerExample implements IAnnotationTransformer {
				    @Override
				    public void transform(ITestAnnotation annotation, Class testClass,
				                          Constructor testConstructor, Method testMethod) {
				        if (isTestDisabled(testMethod)) {
				            annotation.setEnabled(false); // Disable the test method
				        }
				    }
				
				    private boolean isTestDisabled(Method testMethod) {
				        // Add your logic here to determine if the test should be disabled
				        // For example, you can check if the test method has a specific annotation
				        return testMethod.isAnnotationPresent(DisableTest.class);
				    }
			}
 */
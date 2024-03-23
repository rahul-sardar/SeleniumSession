package com.qa.groupingExample;

import org.testng.annotations.Test;


public class SubCategoryGroupExampleDemoLogin {
  @Test(groups = {"windows.smoke" , "windows.sanity" , "windows.Regression" , "windows.login"})
  public void loginWithValidCredential() {
	  System.out.println("loginwithValidCredentials - DemoLogin");
  }
  
  @Test(groups = { "windows.sanity" ,"windows.Regression" , "ios.login"})
  public void logibWithInvalidEmailandInvalidPassword() {
	  System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin");
	  
  }
  
  @Test(groups = {"linux.sanity" ,"linux.Regression" , "login"})
  public void logibWithInvalidEmailandValidPassword() {
	  System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin");
	  
  }
  
  @Test(groups = {"linux.smoke" , "linux.sanity" , "ios.Regression" , "login"})
  public void loginWithInvalidCredentials() {
	  System.out.println("loginWithInvalidCredentials - DemoLogin");
	  
  }
  
  @Test(groups = {"windows.sanity" , "linux.Regression" , "ios.login"})
  public void loginWithoutProvidingCredentials() {
	  System.out.println("loginWithoutProvidingCredentials - DemoLogin");
	  
  }
  
 /*
   * When we declare the group at class level then its called partial group.
   * Group will be applied to all the test present under that class
   * 
 */
  
}

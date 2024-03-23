package com.qa.groupingExample;

import org.testng.annotations.Test;

@Test(groups= {"all"})
public class PartialGroupExampleDemoLogin {
  @Test(groups = {"smoke" , "sanity" , "Regression" , "login"})
  public void loginWithValidCredential() {
	  System.out.println("loginwithValidCredentials - DemoLogin");
  }
  
  @Test(groups = { "sanity" ,"Regression" , "login"})
  public void logibWithInvalidEmailandInvalidPassword() {
	  System.out.println("logibWithInvalidEmailandInvalidPassword - DemoLogin");
	  
  }
  
  @Test(groups = {"sanity" ,"Regression" , "login"})
  public void logibWithInvalidEmailandValidPassword() {
	  System.out.println("logibWithInvalidEmailandValidPassword - DemoLogin");
	  
  }
  
  @Test(groups = {"smoke" , "sanity" , "Regression" , "login"})
  public void loginWithInvalidCredentials() {
	  System.out.println("loginWithInvalidCredentials - DemoLogin");
	  
  }
  
  @Test(groups = {"sanity" , "Regression" , "login"})
  public void loginWithoutProvidingCredentials() {
	  System.out.println("loginWithoutProvidingCredentials - DemoLogin");
	  
  }
  
 /*
   * When we declare the group at class level then its called partial group.
   * Group will be applied to all the test present under that class
   * 
 */
  
}

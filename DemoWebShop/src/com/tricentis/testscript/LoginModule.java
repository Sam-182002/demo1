package com.tricentis.testscript;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tricentis.generic.BaseClass;
import com.tricentis.pom.DashboardPage;
import com.tricentis.pom.LoginPage;
@Listeners(com.tricentis.generic.ListnerImplementation.class)
public class LoginModule extends BaseClass {

	
	
	@Test(dataProvider = "testCaseData")
	public void loginSuccess(String email , String password) {
		
		DashboardPage dp = new DashboardPage(driver);
		dp.clickLoginLink();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginUser(email, password);
		Assert.assertTrue(!driver.getTitle().contains("Login") , "Login Failed");
		
		logOut();
	}
	
	@Test(dataProvider = "testCaseData")
	public void loginWithInvalidCred(String email , String password) {

		DashboardPage dp = new DashboardPage(driver);
		dp.clickLoginLink();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginUser(email, password);
		
		Assert.assertTrue(driver.getTitle().contains("Login") , "Login Successed");
		logOut();
	}

	

	
	
	
}

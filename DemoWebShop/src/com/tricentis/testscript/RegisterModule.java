package com.tricentis.testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.DashboardPage;
import com.tricentis.pom.RegisterPage;

@Listeners(com.tricentis.generic.ListnerImplementation.class)
public class RegisterModule extends BaseClass {

	@Test(dataProvider = "testCaseData")
	public void register_validation(String gender, String firstName, String lastName, String email, String password,
			String confirmPassword, String expectedResult) {
		DashboardPage dp = new DashboardPage(driver);
		dp.clickRegisterLink();
		RegisterPage rp = new RegisterPage(driver);
		rp.registerForm(gender, firstName, lastName, email, password, confirmPassword);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".field-validation-error")));

		List<String> actualResult = rp.getErrorMessages();

		Assert.assertTrue(actualResult.contains(expectedResult), "Result passed");

	}

	@Test(dataProvider = "testCaseData", priority = 0)
	public void register_success(String gender, String firstName, String lastName, String email, String password,
			String confirmPassword) {
		DashboardPage dp = new DashboardPage(driver);
		dp.clickRegisterLink();
		RegisterPage rp = new RegisterPage(driver);
		rp.registerForm(gender, firstName, lastName, email, password, confirmPassword);

		String msg = rp.getRegisterSuccessMessage();
		Assert.assertEquals(msg, "Your registration completed");

	}

}

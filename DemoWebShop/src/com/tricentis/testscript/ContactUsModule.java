package com.tricentis.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.ContactUsPage;
import com.tricentis.pom.HomePage;
@Listeners(com.tricentis.generic.ListnerImplementation.class)
public class ContactUsModule extends BaseClass{


	
	@Test(groups = {"smoke"})
	public void enquiry() throws InterruptedException, EncryptedDocumentException, IOException{
		
		login();
//		 String enq = file.ReadExcelData("contactUs", 1, 1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
		
		HomePage hp = new  HomePage(driver);
		
		hp.clickContactUs();
		
		ContactUsPage cp = new ContactUsPage(driver);
		
		cp.enterText("HelloWord");
		
		String res = cp.getMessageText();
		Assert.assertTrue(res.contains("successfully"));
		logOut();
	}
	

}

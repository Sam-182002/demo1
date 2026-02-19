package com.tricentis.testscript;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ProductPage;
import com.tricentis.pom.ReviewPage;
import com.tricentis.pom.SearchPage;
@Listeners(com.tricentis.generic.ListnerImplementation.class)
public class ReviewModule extends BaseClass{

	

	@Test(enabled= false)
	public void reviewProduct() {

		login();
		
		HomePage hp = new HomePage(driver);
		
		hp.clickShoesLink();
		
		
		
		SearchPage sp = new SearchPage(driver);
		sp.selectItem("Sneaker");
		
		
		ProductPage pp = new ProductPage(driver);
		
		pp.clickOnReviewLink();
		
		ReviewPage rp = new ReviewPage(driver);
		rp.enterReviewTitle("title");
		rp.enterReviewSummary("summary");
		rp.rateCheckBox(5);
		rp.clickOnSubmitButton();
		
		String result = rp.getSuccessMessage();
		
		Assert.assertTrue(result.contains("successfully"));
		
		
		
	}


	@Test
	public void vrifyReviewProduct() throws InterruptedException {

		login();
		
		HomePage hp = new HomePage(driver);

		
		hp.clickShoesLink();
		
		
		SearchPage sp = new SearchPage(driver);
		sp.selectItem("Sneaker");
		

		Thread.sleep(2000);
		
		ProductPage pp = new ProductPage(driver);

		Thread.sleep(2000);
		
		pp.clickOnReviewLink();

		Thread.sleep(2000);
		
		ReviewPage rp = new ReviewPage(driver);

		Thread.sleep(2000);
		
		rp.enterReviewTitle("title");

		Thread.sleep(2000);
		
		rp.enterReviewSummary("summary");

		Thread.sleep(2000);
		
		rp.rateCheckBox(5);

		Thread.sleep(2000);
		
		rp.clickOnSubmitButton();
		
		String result = rp.getSuccessMessage();

		Thread.sleep(2000);
		
		Assert.assertTrue(result.contains("successfully"));
		
		logOut();
		
	}
}

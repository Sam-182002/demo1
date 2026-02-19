package com.tricentis.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ProductPage;
import com.tricentis.pom.SearchPage;
import com.tricentis.pom.WishListPage;

public class WishListModule extends BaseClass {

	@Test(groups = { "regression" })
	public void addToWishList() {

		login();
		
		HomePage hp = new HomePage(driver);
		
		
		hp.clickShoesLink();

		SearchPage sp = new SearchPage(driver);
		sp.selectItem("Sneaker");

		ProductPage pp = new ProductPage(driver);
		pp.selectSize(11);
		pp.selectColor(2);
		pp.clickAddToWishList();
		Reporter.log(pp.getWishListMessage(), true);
		pp.goToWishList();

		WishListPage wp = new WishListPage(driver);
		wp.removeAll();

		Reporter.log(wp.getMessage(), true);
		logOut();
	}

	@Test
	public void checkAddedProduct() {

		login();
		
		HomePage hp = new HomePage(driver);
		
		hp.clickShoesLink();
		
		
		
		SearchPage sp = new SearchPage(driver);
		sp.selectItem("Sneaker");
		
		
		ProductPage pp = new ProductPage(driver);
		pp.selectSize(11);
		pp.selectColor(2);
		String [] poductName = pp.getSelectedNamesAndPrice();
		
		

		pp.clickAddToWishList();
		
		Reporter.log( pp.getSelectedNamesAndPrice()[0],true);
		Reporter.log( pp.getSelectedNamesAndPrice()[0],true);
		Reporter.log(pp.getWishListMessage(), true);
		
		pp.goToWishList();

		
		WishListPage wp = new WishListPage(driver);
		
		boolean b = wp.isNameAndPricePresent(poductName);
		Reporter.log("name and prices match with selected product: " + b , true);
		Assert.assertTrue(b);
		
		logOut();
		
	}

}

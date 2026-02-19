package com.tricentis.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.partialLinkText("Apparel & Shoes")).click();
	
	
	@FindBy(partialLinkText ="Apparel & Shoes" )
	private WebElement shoesLink;
	
	
	@FindBy(linkText = "Contact us")
	private WebElement contactUsLink;
	
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	

	@FindBy(linkText = "Wishlist")
	private WebElement wishListLink;


	@FindBy(className  = "ico-cart")
	private WebElement shoopingCartLink;
	

	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Books')]")
	private WebElement headerBooksLink;
	
	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Computers')]")
	private WebElement headerComputersLink;
	
	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Electronics')]")
	private WebElement headerElectronicsLink;
	
	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Apparel & Shoes')]")
	private WebElement headerShoesLink;
	
	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Digital downloads')]")
	private WebElement headerDigitalDownloads;
	

	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Apparel & Shoes')]")
	private WebElement headerJewelry;
	
	@FindBy(xpath =  "//div[@class='header-menu']/descendant::a[contains(text(),'Digital downloads')]")
	private WebElement headerGiftCards;
	
	
	
	public void searchProduct(String product) {
		
		searchBox.sendKeys(product ,Keys.ENTER);
	}
	
	
	
	public void clickContactUs() {
		contactUsLink.click();
	}
	
	
	public void clickLogoutLink() {
		try {
			logoutLink.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void clickShoesLink() {
		shoesLink.click();
	}
	
	public void goToWishList() {
		wishListLink.click();
	}
	public void goToShoopingCart() {
		shoopingCartLink.click();
	}

}

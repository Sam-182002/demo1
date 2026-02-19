package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className =  "ico-logout")
	private WebElement logOutLink;
	
	@FindBy(xpath = "//div[@class='attributes']//select")
	private WebElement sizeOptions;

	@FindBy(xpath = "(//span[@class='color'])[3]")
	private WebElement selectColorGreen;

	@FindBy(xpath = "(//span[@class='color'])[1]")
	private WebElement selectColorWhite;

	@FindBy(xpath = "(//span[@class='color'])[2]")
	private WebElement selectColorBlack;

	@FindBy(xpath = "//input[@value='Add to wishlist']")
	private WebElement addToWishListButton;

	@FindBy(xpath = "//div[contains(@class,'bar-notification')]//p")
	private WebElement addToWishListMessage;

	@FindBy(linkText = "Wishlist")
	private WebElement wishListLink;

	@FindBy(xpath   = "//div[@class='product-name']/h1")
	private WebElement selectedProductName;

	@FindBy(xpath = "//span[@itemprop='price']")
	private WebElement selectedProductPrice;


	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(className  = "ico-cart")
	private WebElement shoopingCartLink;
	
	
	@FindBy(linkText =  "Add your review")
	private WebElement addYourReviewLink;
	
	public void selectSize(int index) {
		Select s = new Select(sizeOptions);

		switch (index) {

		case 8:
			s.selectByIndex(0);
			break;

		case 9:
			s.selectByIndex(1);
			break;

		case 10:
			s.selectByIndex(2);
			break;

		case 11:
			s.selectByIndex(3);
			break;

		}

	}

	public void selectColor(int index) {

		switch (index) {

		case 1:
			selectColorWhite.click();
			break;

		case 2:
			selectColorBlack.click();
			break;

		case 3:
			selectColorGreen.click();
			break;

		default:
			selectColorGreen.click();
			break;

		}

	}

	public void clickAddToWishList() {
		addToWishListButton.click();

	}
	public void clickAddToCart() {
		addToCartButton.click();
	}
	

	public String getWishListMessage() {
		return addToWishListMessage.getText();
	}

	public void goToWishList() {
		wishListLink.click();
	}
	public void goToShoopingCart() {
		shoopingCartLink.click();
	}

	public String[] getSelectedNamesAndPrice() {
		return new String[] { selectedProductName.getText(), selectedProductPrice.getText() };
	}
	
	public void clickOnReviewLink() {
		addYourReviewLink.click();
	}
	public void clickOnlogOutLink() {
		
		logOutLink.click();
	}
	
	
}

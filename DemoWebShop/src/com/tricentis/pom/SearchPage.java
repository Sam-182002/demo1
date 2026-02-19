package com.tricentis.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	
	public SearchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(className  = "ico-cart")
	private WebElement shoopingCartLink;
	
	@FindBy(xpath = "//h2[@class='product-title']/a")
	private List<WebElement> itemresult;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[text()='shopping cart']/..")
	private WebElement addedResultMessageText;

	@FindBy(xpath = "//h2[@class='product-title']/a")
	private List<WebElement> productTitle;
	
	@FindBy(className = "actual-price")
	private List<WebElement> productPrice;
	
	
	
	public void selectItem(String name) {
		if(itemresult.isEmpty()) return ;
		for(WebElement ele : itemresult) {
			if(ele.getText().contains(name)) {
				ele.click();
				break;
			}
		}
		
	}
	
	public void addToCart(){
		
		addToCartButton.click();
	}
	public String getAddedresult() {
		return addedResultMessageText.getText();
	}
	
	public Object[][] getAllNamesAndPrices(){
		
		Object[][] data = new Object[productTitle.size()][2];
		
		if(productPrice.size() == productTitle.size())
		{
			for(int i = 0 ; i < productTitle.size() ; i ++) {
				data[i][0] = productTitle.get(i).getText();
				data[i][1] = productPrice.get(i).getText();
				
			}
		}
		return data;
		
	}
	
	
	
	
	
	
}

package com.tricentis.generic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.tricentis.pom.DashboardPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.LoginPage;

public class BaseClass {

	public  WebDriver driver;
	public  static ExcelDataHelper excel;
	public   WebDriverWait wait;
	public static PropertiesDataHelper propertiesFile;
	@DataProvider(name = "testCaseData")
	public Object[][] excelDataProvider(Method testMethodName) {

		String sheetName = testMethodName.getName();
		
		
		int rowLength = excel.getRowLength(sheetName);
		int colLength = excel.getColLength(sheetName);
		

		Object[][] table = new Object[rowLength-1][colLength];
		
		
		for(int i = 1 ; i < rowLength ; i++) {
			for(int j = 0 ; j < colLength ; j++) {
				table[i - 1][j] = excel.getData(sheetName, i, j);
			}
		}
		return table;
	}
	
	
	@BeforeSuite
	public static void setUp(){
		
		excel = new ExcelFile("./testdata/testCaseData.xlsx");
		propertiesFile = new PropertiesFile("./testdata/commondata.properties");

	}
	
//	@Parameters("url")
	@BeforeMethod
	public void openBrowser() throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String url = propertiesFile.getData("url");
		driver.get(url);
		
	}
	
	public void login() {
		DashboardPage dp = new DashboardPage(driver);
		dp.clickLoginLink();
		LoginPage lp = new LoginPage(driver);
		String email = propertiesFile.getData("email");
		String pwd = propertiesFile.getData("pwd");
		lp.loginUser(email, pwd);
	}
	
	public void logOut() {
		HomePage hp = new HomePage(driver);
		hp.clickLogoutLink();
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
	}
	@AfterSuite
	public void closeSetUp() {
		
		excel.closeWorkbook();
	}
	
	
	
}


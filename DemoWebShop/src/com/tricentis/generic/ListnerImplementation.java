package com.tricentis.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerImplementation  implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName();
		Reporter.log(methodName + "has been passed" , true);
	}
	@Override
	public void onTestFailure(ITestResult result) {

	    String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	    String methodName = result.getName();

	    // Get current test class object
	    Object currentClass = result.getInstance();

	    // Cast to BaseClass
	    WebDriver driver = ((BaseClass) currentClass).driver;

	    if (driver != null) {

	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);

	        File des = new File("./screenshots/" + methodName + "_" + timeStamp + ".png");

	        try {
	            FileHandler.copy(src, des);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		
		Reporter.log(methodName + " has been skipped" , true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}

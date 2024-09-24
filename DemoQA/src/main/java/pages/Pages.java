package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commons.TestBase;

public class Pages {
	
	public WebDriver drPage; 
	public TestBase testBase = new TestBase();

	public Pages(WebDriver driverWeb) {
		testBase.driver = driverWeb;
		this.drPage = testBase.driver;
	}
	
	
}

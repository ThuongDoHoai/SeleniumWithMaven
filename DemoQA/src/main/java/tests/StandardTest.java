package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commons.TestBase;

public class StandardTest {

	TestBase testBase = new TestBase();
	
	@BeforeTest 
	public void openPage() throws InterruptedException {
		testBase.openPage();
	}

	//@AfterTest
	public void tearDown() {
		testBase.driver.quit();
	}

}

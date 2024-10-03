package tests;

import org.testng.annotations.BeforeTest;

import commons.TestBase;

public class TestCase {
	
	protected TestBase testBase = new TestBase();
	
	@BeforeTest
	public void openPage() throws InterruptedException {
		testBase.openPage();
	}
	

}
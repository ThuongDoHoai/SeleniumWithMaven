package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commons.TestBase;
import pages.ElementPage;
import pages.HomePage;
import pages.TextBoxPage;

public class StandardTest {

	TestBase testBase = new TestBase();
	
	//@BeforeTest 
	public void openPage() throws InterruptedException {
		testBase.openPage();
	}
	
	@BeforeTest
	public TextBoxPage openTextBoxPage() throws InterruptedException {
		testBase.openPage();
		HomePage homePage = new HomePage(testBase.driver);
		ElementPage elementPage = homePage.clickElementMenu();
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		return textBoxPage;
	}

	//@AfterTest
	public void tearDown() {
		testBase.driver.quit();
	}

}

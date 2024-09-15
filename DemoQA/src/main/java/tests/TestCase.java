package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import commons.TestBase;
import pages.ElementPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TestCase {

	TestBase testBase = new TestBase();
	TextBoxPage textBoxPage;

	@BeforeTest
	public void openPage() throws InterruptedException {
		testBase.openPage();
	}

	public TextBoxPage openTextBoxPage() {
		testBase.driver.navigate().to("https://demoqa.com/text-box");
		textBoxPage = new TextBoxPage(testBase.driver);
		return textBoxPage;
	}

	// @AfterTest
	public void tearDown() {
		testBase.driver.quit();
	}

}

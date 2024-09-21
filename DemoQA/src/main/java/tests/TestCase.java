package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commons.TestBase;
import pages.CheckBoxPage;
import pages.PracticeFormPage;
import pages.TextBoxPage;

public class TestCase {

	public TestBase testBase = new TestBase();
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public PracticeFormPage practiceFormPage;

	@BeforeClass
	public void openPage() throws InterruptedException {
		testBase.openPage();
	}

	public TextBoxPage openTexBoxPage() throws InterruptedException {
		testBase.driver.navigate().to("https://demoqa.com/text-box");
		textBoxPage = new TextBoxPage(testBase.driver);
		return textBoxPage;
	}

	public CheckBoxPage openCheckBoxPage() {
		testBase.driver.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage = new CheckBoxPage(testBase.driver);
		return checkBoxPage;
	}
	
	public PracticeFormPage openPracticeFormPage() {
		testBase.driver.navigate().to("https://demoqa.com/automation-practice-form");
		practiceFormPage = new PracticeFormPage(testBase.driver);
		return practiceFormPage;
	}

	// @AfterClass
	public void tearDown() {
		testBase.driver.quit();
	}

}
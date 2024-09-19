package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commons.TestBase;
import pages.CheckBoxPage;
import pages.PracticeFormPage;
import pages.TextBoxPage;

public class TestCase {

	public TestBase drTest = new TestBase();
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public PracticeFormPage practiceFormPage;

	@BeforeClass
	public void openPage() throws InterruptedException {
		drTest.openPage();
	}

	public TextBoxPage openTexBoxPage() throws InterruptedException {
		drTest.driver.navigate().to("https://demoqa.com/text-box");
		textBoxPage = new TextBoxPage(drTest.driver);
		return textBoxPage;
	}

	public CheckBoxPage openCheckBoxPage() {
		drTest.driver.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage = new CheckBoxPage(drTest.driver);
		return checkBoxPage;
	}
	
	public PracticeFormPage openPracticeFormPage() {
		drTest.driver.navigate().to("https://demoqa.com/automation-practice-form");
		practiceFormPage = new PracticeFormPage(drTest.driver);
		return practiceFormPage;
	}

	// @AfterClass
	public void tearDown() {
		drTest.driver.quit();
	}

}
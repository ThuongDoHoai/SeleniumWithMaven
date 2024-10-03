package pages;

import org.openqa.selenium.WebDriver;

import commons.TestBase;

public class Page {
	
	//public WebDriver driverPage;
	protected TestBase testBase = new TestBase();
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public WebTablePage webTablePage;

	public Page(WebDriver driver) {
		//this.driverPage = driver;
		testBase.driver = driver;
	}
	
	public TextBoxPage openTextBoxPage() throws InterruptedException {
		testBase.driver.navigate().to("https://demoqa.com/text-box");
		textBoxPage = new TextBoxPage(testBase.driver);
		return textBoxPage;
	}
	
	public CheckBoxPage openCheckBoxPage() {
		testBase.driver.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage = new CheckBoxPage(testBase.driver);
		return checkBoxPage;
	}
	
	public CheckBoxPage openPracticeFormPage() {
		testBase.driver.navigate().to("https://demoqa.com/automation-practice-form");
		checkBoxPage = new CheckBoxPage(testBase.driver);
		return checkBoxPage;
	}
	
	public WebTablePage openWebTablePage() {
		testBase.driver.navigate().to("https://demoqa.com/webtables");
		webTablePage = new WebTablePage(testBase.driver);
		return webTablePage;
	}

}


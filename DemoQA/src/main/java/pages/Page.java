package pages;

import org.openqa.selenium.WebDriver;

import commons.Configurations;
import commons.TestBase;
import pages.bookstore.LoginPage;

public class Page {
	
	public WebDriver driverPage;
	public TestBase testBase = new TestBase();
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public WebTablePage webTablePage;
	public RadioButtonPage radioButtonPage;
	public LoginPage loginPage;
	public UploadDownloadPage uploadDownloadPage;
	
	public String configFile;
	public Configurations configs;

	public Page(WebDriver driver, String configFile) {
		this.driverPage = driver;
		testBase.driver = driver;
		this.configFile = configFile;
		configs = new Configurations(configFile);
	}
	
	public TextBoxPage openTextBoxPage() throws InterruptedException {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("text_box_page"));
		textBoxPage = new TextBoxPage(testBase.driver, configFile);
		return textBoxPage;
	}
	
	public CheckBoxPage openCheckBoxPage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("check_box_page"));
		System.out.println();
		checkBoxPage = new CheckBoxPage(testBase.driver, configFile);
		return checkBoxPage;
	}
	
	public CheckBoxPage openPracticeFormPage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("practices_form_page"));
		checkBoxPage = new CheckBoxPage(testBase.driver, configFile);
		return checkBoxPage;
	}
	
	public WebTablePage openWebTablePage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("web_table_page"));
		webTablePage = new WebTablePage(testBase.driver, configFile);
		return webTablePage;
	}
	
	public RadioButtonPage openRadioButtonPage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("radio_button_page"));
		radioButtonPage = new RadioButtonPage(testBase.driver, configFile);
		return radioButtonPage;
	}
	
	public LoginPage openLoginPage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url")+configs.getConfigValueByKey("login_page"));
		loginPage = new LoginPage(testBase.driver, configFile);
		return loginPage;
	}
	
	public UploadDownloadPage openUploadDownloadPage() {
		testBase.driver.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("upload_download_page"));
		uploadDownloadPage = new UploadDownloadPage(testBase.driver, configFile);
		return uploadDownloadPage;
	}

}


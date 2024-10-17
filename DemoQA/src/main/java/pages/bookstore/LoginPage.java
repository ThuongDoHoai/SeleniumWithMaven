package pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.Page;

public class LoginPage extends Page{
	
	public By txtUserName = By.id("userName");
	public By txtPass = By.id("password");
	public By btnLogin = By.id("login");
	
	public By lbErrorMessage = By.id("name"); 

	public LoginPage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}
	
	public void login(String userName, String pass) throws InterruptedException {
			loginPage.testBase.inputText(txtUserName, userName);
			loginPage.testBase.inputText(txtPass, pass);
			loginPage.testBase.clickButton(btnLogin);
	}
	

}

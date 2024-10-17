package pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.Page;

public class ProfilePage extends Page {

	public ProfilePage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}
	
	public By lbUserNameValue = By.id("userName-value");

}

package tests.bookstore;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.bookstore.LoginPage;
import pages.bookstore.ProfilePage;
import tests.TestCase;

public class LoginTest extends TestCase {

	@Test(dataProvider = "Login data")
	public void testLogin(String userName, String pass, String expectedErrorMessage) throws InterruptedException {

		LoginPage loginPage = new LoginPage(testBase.driver, CONFIG_FILE);
		loginPage.openLoginPage();
		WebDriver drLogin = testBase.driver;
		System.out.println(drLogin);
		loginPage.login(userName, pass);
		testBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		if (expectedErrorMessage.equalsIgnoreCase("")) {
			ProfilePage profilePage = new ProfilePage(drLogin, CONFIG_FILE);

			testBase.waitForElemnetDisplayable(profilePage.lbUserNameValue);

			String actualUserName = profilePage.testBase.getTextByLocator(profilePage.lbUserNameValue);
			System.out.println(actualUserName);
			assertEquals(actualUserName, userName);
		} else {
			String actualErrorMessage = testBase.getTextByLocator(loginPage.lbErrorMessage);
			assertEquals(actualErrorMessage, expectedErrorMessage);
		}

	}

	@DataProvider(name = "Login data")
	public String[][] getLoginData() {

		String[][] result = new String[3][3];

		result[0][0] = "dohoaithuong1";
		result[0][1] = "Hanoi2024@";
		result[0][2] = "Invalid username or password!";

		result[1][0] = "dohoaithuong";
		result[1][1] = "Hanoi2024";
		result[1][2] = "Invalid username or password!";
		
		result[2][0] = "dohoaithuong";
		result[2][1] = "Hanoi2024@";
		result[2][2] = "";

		return result;
	}

}

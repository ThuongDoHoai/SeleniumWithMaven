package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage extends Page {

	public By rdYes = By.id("yesRadio");
	public By rdImpressive = By.id("impressiveRadio");
	public By rdNo = By.id("noRadio");
	
	public By lblSelectedRadio = By.xpath("//span[@class='text-success']");

	public RadioButtonPage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}

	public boolean isCheckDefault(By locator1, By locator2, By locator3) {
		WebElement radioNo = testBase.driver.findElement(locator3);

		String attributeRadioNo = radioNo.getAttribute("class");

		if (attributeRadioNo.contains("disabled")) {
			if (isCheck(locator2) == false && isCheck(locator3) == false)
				return true;

		}
		return false;
	}

	public boolean isCheck(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		if (element.isSelected())
			return true;
		return false;
	}

	public String getTextLable(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		String result = element.getText();
		return result;
	}

}

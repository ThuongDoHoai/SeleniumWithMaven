package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page {

	public By chbHome = By.xpath("//span[@class='rct-checkbox']//*[name()='svg']");
	public By arrHome = By.xpath("//button[@title='Toggle']/*[name()='svg']");
	public By lblResult = By.xpath("//*[@id='result']/span");
	public By lblListCheckBoxes = By.xpath("//span[@class='rct-title']");
	public By chbListCheckBoxes = By.xpath("//span[@class='rct-checkbox']/*[name()='svg']");

	public CheckBoxPage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}

	public boolean verifyCheckingOfCheckBox(By locator) {
		WebElement element = testBase.driver.findElement(locator);

		String attribute = element.getAttribute("class");
		if (attribute.contains("rct-icon-check")) {
			return true;
		}
		return false;
	}

	public boolean checkCheckingOfCheckBoxes() {
		List<WebElement> elements = testBase.driver.findElements(chbListCheckBoxes);
		int i = 0;
		while (i < elements.size()) {
			if (elements.get(i).getAttribute("class").contains("rct-icon-check")) {
				i++;
			} else
				return false;
		}
		return true;
	}

	public String getLableResult(By locator) {
		List<WebElement> elements = testBase.driver.findElements(locator);

		String lblOutput = "";

		for (WebElement e : elements) {
			lblOutput = lblOutput + " " + e.getText();
		}

		return lblOutput.trim();
	}

	public void clickButton(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		element.click();
	}

	public boolean checkLabelCheckBoxes(String[] lblcheckBoxes) {
		List<WebElement> elements = testBase.driver.findElements(lblListCheckBoxes);
		int i = 0;

		while (i < elements.size()) {
			if (elements.get(i).getText().equals(lblcheckBoxes[i])) {
				i++;
			} else
				return false;
		}
		return true;
	}

}


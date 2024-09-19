package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Pages {

	public WebElement checkBoxHome = drPage.findElement(By.xpath("//span[@class='rct-checkbox']"));
	public WebElement arrowHome = drPage.findElement(By.xpath("//button[@title='Toggle']"));

	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}

	public boolean getUnCheckingStatus(WebElement locator) {
		String attribute = locator.getAttribute("class");

		if (attribute.contains("uncheck")) {
			return true;
		} 
		else return false;
	}
	
	public boolean getCheckingStatus(WebElement locator) {
		String attribute = locator.getAttribute("class");

		if (attribute.contains("check")) {
			return true;
		} 
		else return false;
	}
	

	public void clickCheckBoxHome() {
		checkBoxHome.click();
	}
	
	public void clickArrowHome() {
		arrowHome.click();
	}

	public String getTextAfterClick() {
		String actualText = "";
		List<WebElement> elements = drPage.findElements(By.xpath("//div[@id='result']/span"));

		for (WebElement e : elements) {
			actualText = actualText + " " + e.getText();
		}
		return actualText.trim();

	}

	public String getlableSubCheckBoxs(WebElement locator) {
		String lableSubNote = locator.getText();
		return lableSubNote;
	}

}

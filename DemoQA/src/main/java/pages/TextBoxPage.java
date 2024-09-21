package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.TestBase;

public class TextBoxPage extends Pages {

	public WebElement inputFullName = drPage.findElement(By.xpath("//input[@id='userName']"));
	public WebElement inputEmail = drPage.findElement(By.xpath("//input[@id='userEmail']"));
	public WebElement inputCurrentAdd = drPage.findElement(By.xpath("//textarea[@id='currentAddress']"));
	public WebElement inputPermanentAdd = drPage.findElement(By.xpath("//textarea[@id='permanentAddress']"));

	public By outputFullName = By.xpath("//div[@id='output']//p[@id='name']");
	public By outputEmail = By.xpath("//div[@id='output']//p[@id='email']");
	public By outputCurrentAdd = By.xpath("//div[@id='output']//p[@id='currentAddress']");
	public By outputPermanentAdd = By.xpath("//div[@id='output']//p[@id='permanentAddress']");

	public By outputArea = By.xpath("//div[@id='output']/div");

	public TextBoxPage(WebDriver driver) {
		super(driver);
	}

	public void clickSubmit() {
		WebElement submitButton = drPage.findElement(By.xpath("//button[@id='submit']"));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

		submitButton.click();
	}

	public String getTextAfterSubmit(By locator) {

		String text = drPage.findElement(locator).getText();

		int index = text.indexOf(":");
		String result = text.substring(index + 1);

		return result;

	}

	public boolean getErrorField(WebElement locator) {
		String attributeValue = locator.getAttribute("class");

		if (attributeValue.contains("field-error")) {
			return true;
		} else
			return false;
	}

	public boolean getUnSaveServe(By locator) {
		String attributeValue = drPage.findElement(locator).getAttribute("class");

		if (attributeValue.contains("undefined")) {
			return true;
		} else
			return false;
	}
}
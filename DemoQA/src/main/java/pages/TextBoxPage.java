package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.TestBase;

public class TextBoxPage extends Pages {

	public By lblInputFullName = By.xpath("//input[@id='userName']");
	public By lblInputEmail = By.xpath("//input[@id='userEmail']");
	public By lblInputCurrentAdd = By.xpath("//textarea[@id='currentAddress']");
	public By lblInputPermanentAdd = By.xpath("//textarea[@id='permanentAddress']");

	public By lblOuputFullName = By.xpath("//p[@id='name']");
	public By lblOutputEmail = By.xpath("//p[@id='email']");
	public By lblOutputCurrentAdd = By.xpath("//p[@id='currentAddress']");
	public By lblOutputPermanentAdd = By.xpath("//p[@id='permanentAddress']");
	
	public By lblOuputArea = By.xpath("//div[@id='output']/div");

	public TextBoxPage(WebDriver driver) {
		super(driver);
	}

	public void inputData(By locator, String value) {
		WebElement control = drPage.findElement(locator);
		control.sendKeys(value);
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
	
	public boolean getErrorField(By locator) {
		String attributeValue = drPage.findElement(locator).getAttribute("class");
		
		if(attributeValue.contains("field-error")) {
			return true;
		}
		else return false;
	}
	
	public boolean getUnSaveServe(By locator) {
		String attributeValue = drPage.findElement(locator).getAttribute("class");
		
		if (attributeValue.contains("undefined")) {
			return true;
		}else return false;
	}
}
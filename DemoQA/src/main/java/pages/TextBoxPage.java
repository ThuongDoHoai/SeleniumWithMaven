package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Pages {

	public By lblNameInput = By.xpath("//input[@id='userName']");
	public By lblEmailInput = By.xpath("//input[@id='userEmail']");
	public By lblCurrentAddInput = By.xpath("//textarea[@id='currentAddress']");
	public By lblPermanetAddInput = By.xpath("//textarea[@id='permanentAddress']");

	public By lblNameOutput = By.xpath("//div[@id='output']//p[@id='name']");
	public By lblEmailOutput = By.xpath("//div[@id='output']//p[@id='email']");
	public By lblCurrentAddOutput = By.xpath("//div[@id='output']//p[@id='currentAddress']");
	public By lblPermanetAddOutput = By.xpath("//div[@id='output']//p[@id='permanentAddress']");

	public TextBoxPage(WebDriver BaseDr) {
		super(BaseDr);
	}

	public void inputText(By locator, String inputValue) {
		dr.findElement(locator).sendKeys(inputValue);
	}

	public void clickSubmit() {
		WebElement submitButton = dr.findElement(By.xpath("//button[@id='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
	}

	public String getTextAfterSubmit(By locator) {
		int indexColon;
		
		WebElement control = dr.findElement(locator);
		String outputText = control.getText();

		indexColon = outputText.indexOf(":");
		String result = outputText.substring(indexColon + 1);

		return result;
	}

}

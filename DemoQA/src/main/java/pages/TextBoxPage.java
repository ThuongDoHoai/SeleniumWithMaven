package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {
	
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrAdd = By.id("currentAddress");
	public By txtPerAdd = By.id("permanentAddress");
	
	public By outputName = By.id("name");
	public By outputEmail = By.id("email");
	public By outputCurrAdd = By.xpath("//p[@id='currentAddress']");
	public By outputPerAdd = By.xpath("//p[@id='permanentAddress']");
	
	public By btnSubmit = By.id("submit");

	public TextBoxPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void inputDataAllField(String fullName, String email, String currentAdd, String perAdd) throws InterruptedException {
		testBase.inputText(txtFullName, fullName);
		testBase.inputText(txtEmail, email);
		testBase.inputText(txtCurrAdd, currentAdd);
		testBase.inputText(txtPerAdd, perAdd);
		
		testBase.clickButton(btnSubmit);
	}
	
	public String getTextAfterSubmit(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		String output = element.getText();
		int index = output.indexOf(":");
		output = output.substring(index+1);
		return output;
	}
	
	public boolean checkErrorField(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		String error_field = element.getAttribute("class");
		if (error_field.contains("field-error")) {
			return true;
		}
		return false;
	}

}
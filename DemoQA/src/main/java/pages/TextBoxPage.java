package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Pages {

	public TextBoxPage(WebDriver BaseDr) {
		super(BaseDr);
	}
	
	//
	//TC-01_Submit success
	//
	public void inputValidData() {
		WebElement fullNameField = dr.findElement(By.xpath("//input[@id='userName']"));
		fullNameField.sendKeys("Do Hoai Thuong");

		WebElement emailField = dr.findElement(By.xpath("//input[@id='userEmail']"));
		emailField.sendKeys("dohoaithuong1989@gmai.com");

		WebElement currentAddressField = dr.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAddressField.sendKeys("Ha Noi");

		WebElement permanetAddressField = dr.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		permanetAddressField.sendKeys("Thai Nguyen");
	}
	
	public void clickSubmitValid() {
		WebElement submitButton = dr.findElement(By.xpath("//button[@id='submit']"));
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		
		submitButton.click();
	}
	
	//
	//TC-02_Input invalid data: Email format is wrong (without "@")
	//
	public void inputInValidData_1() {
		WebElement fullNameField = dr.findElement(By.xpath("//input[@id='userName']"));
		fullNameField.sendKeys("Do Hoai Thuong");

		WebElement emailField = dr.findElement(By.xpath("//input[@id='userEmail']"));
		emailField.sendKeys("dohoaithuong1989gmai.com");

		WebElement currentAddressField = dr.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAddressField.sendKeys("Ha Noi");

		WebElement permanetAddressField = dr.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		permanetAddressField.sendKeys("Thai Nguyen");
	}

	
	public void clickSubmitInvalid_1() {
		WebElement submitButton = dr.findElement(By.xpath("//button[@id='submit']"));
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		
		submitButton.click();
		
		WebElement emailField = dr.findElement(By.xpath("//input[@id='userEmail']"));
		js.executeScript("arguments[0].scrollIntoView(true);", emailField);
	}
	
	//
	//TC-03_Input invalid data: Email format is wrong (without domain)
	//
	public void inputInValidData_2() {
		WebElement fullNameField = dr.findElement(By.xpath("//input[@id='userName']"));
		fullNameField.sendKeys("Do Hoai Thuong");

		WebElement emailField = dr.findElement(By.xpath("//input[@id='userEmail']"));
		emailField.sendKeys("dohoaithuong1989@");

		WebElement currentAddressField = dr.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAddressField.sendKeys("Ha Noi");

		WebElement permanetAddressField = dr.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		permanetAddressField.sendKeys("Thai Nguyen");
	}

	
	public void clickSubmitInvalid_2() {
		WebElement submitButton = dr.findElement(By.xpath("//button[@id='submit']"));
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		
		submitButton.click();
		
		WebElement emailField = dr.findElement(By.xpath("//input[@id='userEmail']"));
		js.executeScript("arguments[0].scrollIntoView(true);", emailField);
	}

}

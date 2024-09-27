package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementPage extends Pages {

	public ElementPage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public TextBoxPage clickTextBox() {
		WebElement textBoxMenu = drPage.findElement(By.xpath("//span[text()='Text Box']"));
		textBoxMenu.click();
		return new TextBoxPage(drPage);
	}

}

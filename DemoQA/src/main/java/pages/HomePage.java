package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Pages {

	public HomePage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public ElementPage clickElementMenu() {

		WebElement elementMenu = drPage.findElement(By.xpath("//h5[text()='Elements']"));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", elementMenu);

		elementMenu.click();
		return new ElementPage(drPage);
	}

}

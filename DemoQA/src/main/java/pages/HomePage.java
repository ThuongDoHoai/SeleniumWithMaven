package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Pages {

	public HomePage(WebDriver baseDr) {
		super(baseDr);
	}

	public ElementPage clickElementMenu() {

		WebElement elementMenu = dr.findElement(By.xpath("//h5[text()='Elements']"));

		JavascriptExecutor js = (JavascriptExecutor) dr;

		js.executeScript("arguments[0].scrollIntoView(true);", elementMenu);

		elementMenu.click();
		return new ElementPage(dr);
	}

}

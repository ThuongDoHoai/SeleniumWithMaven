package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commons.TestBase;

public class PracticeFormPage extends Pages {

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void inputData() {

	}
	
	public void inputDate() {
		drPage.findElement(By.id("//input[@id='dateOfBirthInput']")).click();
		WebElement drYear = drPage.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		
		Select selectYear = new Select(drYear);
		selectYear.selectByVisibleText("");
	}

}

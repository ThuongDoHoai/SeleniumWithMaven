package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commons.TestBase;

public class PracticeFormPage extends Pages {

	public PracticeFormPage(WebDriver driverWeb) {
		super(driverWeb);
	}
	
	public void inputData() {

	}
	
	public void inputDate() {
		dr.findElement(By.id("//input[@id='dateOfBirthInput']")).click();
		WebElement drYear = dr.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		
		Select selectYear = new Select(drYear);
		selectYear.selectByVisibleText("");
	}

}
